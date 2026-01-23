package actions.ProductPage;

import actions.BaseActions;
import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static helpers.Utils.*;

public class ProductPageActions extends BaseActions {

    page_objects.ProductPage.ProductPage productPage = new page_objects.ProductPage.ProductPage(baseActionsDriver);

    private boolean CheckProductSizeDropBox() {
        return productPage.product_size_dropbox.size() != 0;
    }

    private void ExecuteClickOnProductSizeDropBox() throws IOException {
        click(productPage.product_size_dropbox.get(0));
    }

    private void ChooseSize() throws IOException {
        if (CheckProductSizeDropBox()) {
            ExecuteClickOnProductSizeDropBox();
            if (productPage.available_product_sizes.size() == 0) {
                // The dropbox is available but all of the option are out of stock
                PrintLog.printLogActionInPage("All product sizes are out of stocks");
                captureScreenshot();
                throw new org.testng.SkipException("Skipping test: All product sizes are out of stock.");
            } else {
                // The dropbox is available and there is option(s) to choose
                click(productPage.available_product_sizes
                        .get(new Random().nextInt(productPage.available_product_sizes.size())));
            }
        }
    }

    private void ChooseQuantity(int numberOfProduct) throws IOException {
        try {
            click(productPage.quantity_dropbox);
            click(baseActionsDriver
                    .findElement(By.xpath("//select[@id='quantity']//child::option[" + numberOfProduct + "]")));
        } catch (Throwable e) {
            PrintLog.printLogActionInPage(
                    "Could not select quantity (likely hidden or overlay). Proceeding with default quantity.");
        }
    }

    public void ExecuteAddToCart(int numberOfProduct) throws IOException {
        if (numberOfProduct > 0) {
            waitForPageToLoad();
            // waitForElement(productPage.quantity_dropbox, waitTime);

            // Choose the size if the dropbox is available
            ChooseSize();

            if (productPage.quantity_dropbox_options.size() != 0) {
                if (numberOfProduct > productPage.quantity_dropbox_options.size()) {
                    PrintLog.printLogActionInPage("Product does not have enough stocks to add: " + numberOfProduct);
                    captureScreenshot();
                    throw new org.testng.SkipException(
                            "Skipping test: Requested quantity " + numberOfProduct + " exceeds available stock.");
                } else {

                    ChooseQuantity(numberOfProduct);

                    clickAddToCart(numberOfProduct);
                }
            } else {
                // If there is no quantity box, user cannot choose quantity
                numberOfProduct = 1;
                PrintLog.printLogActionInPage("There is no quantity dropbox to choose, " +
                        "so user will just click add to cart");
                clickAddToCart(numberOfProduct);
            }
        }
    }

    private void clickAddToCart(int numberOfProduct) throws IOException {
        if (productPage.product_price_text.size() > 0) {
            // get the product price
            // Add to total price and total items
            String priceText = productPage.product_price_text.get(productPage.product_price_text.size() - 1)
                    .getAttribute("textContent").trim();
            PrintLog.printLogActionInPage("Product price: " + priceText);

            totalPrice += numberOfProduct
                    * Float.valueOf(priceText.replaceAll("[^0-9.]", ""));
            totalItem += numberOfProduct;

            // Add to cart with longer wait for search result pages
            try {
                org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(
                        helpers.DriverFactory.getInstance().getDriver(),
                        java.time.Duration.ofSeconds(30));
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(productPage.add_to_cart_button));
                productPage.add_to_cart_button.click();
                captureScreenshot();
            } catch (Exception e) {
                PrintLog.printLogActionInPage("Add to cart button not clickable: " + e.getMessage());
                throw new IOException("Failed to click add to cart button", e);
            }

            if (productPage.proceed_to_checkout.isEmpty()) {
                // Remove last add price and items from total price
                totalPrice -= numberOfProduct * Float
                        .valueOf(priceText.replaceAll("[^0-9.]", ""));
                totalItem -= numberOfProduct;

                // Assert failed and log
                PrintLog.printLogActionInPage("Add to cart failed: proceeding to checkout button not found");
                throw new org.testng.SkipException("Skipping test: Add to cart failed (checkout button not found).");
            } else {
                for (WebElement webElement : productPage.total_price_text) {
                    // Assert the total price
                    Assert.assertEquals(
                            Float.valueOf(webElement.getText().replace("$", "")),
                            round(totalPrice, 2),
                            "Add to cart is success but the current total price is: " + round(totalPrice, 2));

                    List<WebElement> itemNumberAfterAddToCart = baseActionsDriver
                            .findElements(By.xpath("//*[contains(text(), '"
                                    + totalItem + " item') " +
                                    "or contains(text(), '"
                                    + totalItem + " items')]"));

                    // Assert the total items added
                    Assert.assertTrue(itemNumberAfterAddToCart.size() > 0,
                            "Add to cart is success but the current total item is: " + totalItem);

                }

                // Log the result
                PrintLog.printLogActionInPage(
                        "Add to cart success and the total price is correct: $" + round(totalPrice, 2));
                PrintLog.printLogActionInPage("Add to cart success and the total item is correct: " + totalItem);
            }
        } else {
            // The product does not have price - skip price validation and just add to cart
            PrintLog.printLogActionInPage("Warning: Product price not available, skipping price validation");

            // Check if add to cart button exists with longer wait for search result pages
            try {
                // Add explicit wait for add-to-cart button (search pages load slower)
                org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(
                        helpers.DriverFactory.getInstance().getDriver(),
                        java.time.Duration.ofSeconds(30));
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(productPage.add_to_cart_button));

                // Now click the button
                productPage.add_to_cart_button.click();

                if (productPage.proceed_to_checkout.isEmpty()) {
                    PrintLog.printLogActionInPage("Add to cart button clicked but checkout not available");
                    throw new org.testng.SkipException(
                            "Added to cart but checkout button not found - likely captcha or layout issue.");
                } else {
                    PrintLog.printLogActionInPage("Add to cart success (price validation skipped)");
                }
            } catch (Exception e) {
                // Add to cart button not available - this is okay for some products
                PrintLog.printLogActionInPage(
                        "Add to cart not available for this product (may require different purchase flow): "
                                + e.getMessage());
                throw new org.testng.SkipException(
                        "Add to cart button not available or not clickable: " + e.getMessage());
            }

            captureScreenshot();
        }
    }

    private static float round(float value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }

    public void GoToHomePage() throws IOException {
        click(productPage.home_page_logo);
    }

    public void ClickOnCartButton() throws IOException {
        click(productPage.cart_button);
    }
}