package actions.CartPage;

import actions.BaseActions;
import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static helpers.Utils.*;

public class CartPageActions extends BaseActions {

    page_objects.CartPage.CartPage cartPage = new page_objects.CartPage.CartPage(baseActionsDriver);

    public void DeleteItem(int numberOfItem) throws IOException {
        click(cartPage.delete_buttons.get(numberOfItem - 1));
    }

    public void ChangeQuantity(int numberOfItem, int quantity) throws IOException {
        // Adjust index for 0-based list
        int index = numberOfItem - 1;

        // Poll for element appearance (wait up to 10 seconds)
        long endTime = System.currentTimeMillis() + 10000;
        boolean found = false;

        while (System.currentTimeMillis() < endTime) {
            try {
                if ((cartPage.quantity_dropbox.size() > index && cartPage.quantity_dropbox.get(index).isDisplayed()) ||
                        (cartPage.quantity_inputs.size() > index)) {
                    // Check if input is either displayed OR present (for hidden stepper inputs)
                    found = true;
                    break;
                }
            } catch (Exception e) {
                // Ignore stale element exceptions etc during poll
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

        if (!found) {
            throw new IOException("Could not find Quantity selector (dropdown or input) for item number " + numberOfItem
                    + " after waiting. Selects found: " + cartPage.quantity_dropbox.size()
                    + ", Inputs found: " + cartPage.quantity_inputs.size());
        }

        if (cartPage.quantity_dropbox.size() > index && cartPage.quantity_dropbox.get(index).isDisplayed()) {
            // Use Selenium's Select class to handle the quantity dropdown
            org.openqa.selenium.support.ui.Select quantitySelect = new org.openqa.selenium.support.ui.Select(
                    cartPage.quantity_dropbox.get(index));
            quantitySelect.selectByValue(String.valueOf(quantity));
        } else if (cartPage.quantity_inputs.size() > index) {
            WebElement input = cartPage.quantity_inputs.get(index);
            if (input.isDisplayed()) {
                // Handle as text input
                input.clear();
                input.sendKeys(String.valueOf(quantity));
                // Often need to press Enter or click update
                input.sendKeys(org.openqa.selenium.Keys.ENTER);
            } else {
                // Handle hidden input (Stepper UI) via JavaScript
                org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) baseActionsDriver;
                js.executeScript("arguments[0].value = arguments[1];", input, String.valueOf(quantity));
                js.executeScript("arguments[0].dispatchEvent(new Event('change'));", input);
                // Sometimes additional events are needed
                js.executeScript("arguments[0].dispatchEvent(new Event('input'));", input);
                js.executeScript("arguments[0].dispatchEvent(new Event('blur'));", input);
            }
            // Wait for update to reflect
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }

        PrintLog.printLogActionInPage("Change the product number: " + numberOfItem + " to: " + quantity + " item(s)");
        captureScreenshot();
    }

    public boolean checkPriceOnCart() throws IOException {
        float total_price_on_cart = 0;

        waitForPageToLoad();
        waitForElements(cartPage.item_quantities, waitTime);
        waitForElements(cartPage.item_prices, waitTime);
        waitForElements(cartPage.total_prices, waitTime);

        for (int i = 0; i < cartPage.item_prices.size(); i++)
            total_price_on_cart += Float.valueOf(cartPage.item_quantities.get(i).getText())
                    * Float.valueOf(cartPage.item_prices.get(i).getText().replace("$", ""));

        for (WebElement total_price : cartPage.total_prices)
            if (total_price_on_cart != Float.valueOf(total_price.getText().replace("$", ""))) {
                PrintLog.printLogActionInPage("The total price on the cart is NOT correct, total calculated price is: $"
                        + total_price_on_cart
                        + " but the cart price is: "
                        + total_price.getText());
                captureScreenshot();

                return false;
            }

        PrintLog.printLogActionInPage("The total price on the cart is correct: $" + total_price_on_cart);
        captureScreenshot();
        return true;
    }

    public boolean checkQuantityOnCart() throws IOException {
        int total_quantity_on_cart = 0;

        for (WebElement item_quantity : cartPage.item_quantities)
            total_quantity_on_cart += Integer.valueOf(item_quantity.getText());

        List<WebElement> total_quantities_on_cart = baseActionsDriver.findElements(By.xpath("//span[contains(text(), '"
                + total_quantity_on_cart + " item') or contains(text(), '" + total_quantity_on_cart + " items')]"));

        if (total_quantities_on_cart.size() == 0) {
            PrintLog.printLogActionInPage("The total quantity on the cart is NOT correct: $" + total_quantity_on_cart);
            captureScreenshot();
            return false;
        }

        PrintLog.printLogActionInPage("The total quantity on the cart is correct: $" + total_quantity_on_cart);
        captureScreenshot();
        return true;
    }

    public void ClickOnProceedToCheckoutButton() throws IOException {
        click(cartPage.proceed_to_checkout_button);
    }
}