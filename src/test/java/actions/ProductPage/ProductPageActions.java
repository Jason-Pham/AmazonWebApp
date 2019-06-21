package actions.ProductPage;

import actions.BaseActions;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static helpers.Utils.*;
import static page_objects.ProductPage.ProductPage.*;

public class ProductPageActions extends BaseActions {

    private boolean CheckProductSizeDropBox() {
        return product_size_dropbox.size() != 0;
    }

    private void ExecuteClickOnProductSizeDropBox() throws IOException {
        click(product_size_dropbox.get(0));
    }

    private void ChooseSize() throws IOException {
        if (CheckProductSizeDropBox()) {
            ExecuteClickOnProductSizeDropBox();
            if (available_product_sizes.size() == 0) {
                //The dropbox is available but all of the option are out of stock
                Assert.assertTrue(true, "All product sizes are out of stocks");
                Reporter.addStepLog("All product sizes are out of stocks");
                captureScreenshot();
            } else {
                //The dropbox is available and there is option(s) to choose
                click(available_product_sizes.get(new Random().nextInt(available_product_sizes.size())));
            }
        }
    }

    private void ChooseQuantity(int numberOfProduct) throws IOException {
        click(quantity_dropbox);
        click(baseActionsDriver.findElement(By.xpath("//select[@id='quantity']//child::option[" + numberOfProduct + "]")));
    }

    public void ExecuteAddToCart(int numberOfProduct) throws IOException {
        if(numberOfProduct > 0) {
            waitForPageToLoad();
            //waitForElement(quantity_dropbox, waitTime);

            //Choose the size if the dropbox is available
            ChooseSize();

            Reporter.addStepLog("Product price: " + product_price_text.get(product_price_text.size() - 1).getText());

            if (quantity_dropbox_options.size() != 0) {
                if (numberOfProduct > quantity_dropbox_options.size()) {
                    Assert.assertTrue(true, "Product does not have enough stocks to add: " + numberOfProduct);
                    Reporter.addStepLog("Product does not have enough stocks to add: " + numberOfProduct);

                    captureScreenshot();
                } else {

                    ChooseQuantity(numberOfProduct);

                    clickAddToCart(numberOfProduct);
                }
            } else {
                //If there is no quantity box, user cannot choose quantity
                numberOfProduct = 1;
                Reporter.addStepLog("There is no quantity dropbox to choose, " +
                        "so user will just click add to cart");
                clickAddToCart(numberOfProduct);
            }
        }
    }

    private void clickAddToCart(int numberOfProduct) throws IOException {
        if (product_price_text.size() > 0) {
            //get the product price
            String price_text = product_price_text.get(product_price_text.size() - 1).getText().replace("$", "");
            float price = Float.valueOf(price_text);
            float add_to_cart_price = numberOfProduct * price;

            //Add to total price and total items
            totalPrice += add_to_cart_price;
            totalItem += numberOfProduct;

            //Add to cart and capture screenshot
            click(add_to_cart_button);

            if (proceed_to_checkout.isEmpty()) {
                //Remove last add price and items from total price
                totalPrice -= add_to_cart_price;
                totalItem -= numberOfProduct;

                //Assert failed and log
                Assert.assertFalse(false, "Add to cart failed");
                Reporter.addStepLog("Add to cart failed");
            } else {
                for (WebElement webElement : total_price_text) {
                    //Assert the total price
                    Assert.assertEquals(
                            Float.valueOf(webElement.getText().replace("$", "")),
                            round(totalPrice, 2),
                            "Add to cart is success but the current total price is: " + round(totalPrice, 2));

                    List<WebElement> itemNumberAfterAddToCart =
                            baseActionsDriver.findElements
                                    (By.xpath("//*[contains(text(), '"
                                            + totalItem + " item') " +
                                            "or contains(text(), '"
                                            + totalItem + " items')]"));

                    //Assert the total items added
                    Assert.assertTrue(itemNumberAfterAddToCart.size() > 0
                            , "Add to cart is success but the current total item is: " + totalItem);

                }

                //Log the result
                Reporter.addStepLog("Add to cart success and the total price is correct: $" + round(totalPrice, 2));
                Reporter.addStepLog("Add to cart success and the total item is correct: " + totalItem);
            }
        }
        else {
            //The product does not have price
            Reporter.addStepLog("The product does not have price");
            captureScreenshot();
        }
    }
    private static float round(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (float) tmp / factor;
    }

    public void GoToHomePage() throws IOException {
        click(home_page_logo);
    }

    public void ClickOnCartButton() throws IOException {
        click(cart_button);
    }
}