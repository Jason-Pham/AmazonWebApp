package actions.CartPage;

import actions.BaseActions;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static helpers.Utils.*;
import static page_objects.CartPage.CartPage.*;

public class CartPageActions extends BaseActions {
    public void DeleteItem(int numberOfItem) throws IOException {
        click(delete_buttons.get(numberOfItem - 1));
    }

    public void ChangeQuantity(int numberOfItem, int quantity) throws IOException {
        click(quantity_dropbox.get(numberOfItem - 1));

        click(baseActionsDriver.findElement
                (By.xpath("((//div[@class='a-popover a-dropdown a-dropdown-common a-declarative'])" +
                        "[" + numberOfItem + "]" +
                        "//child::li)" +
                        "[" + quantity + "]")));

        Reporter.addStepLog("Change the product number: " + numberOfItem + " to: " + quantity + " item(s)");
        captureScreenshot();
    }

    public boolean checkPriceOnCart() throws IOException {
        float total_price_on_cart = 0;

        waitForPageToLoad();
        waitForElements(item_quantities, waitTime);
        waitForElements(item_prices, waitTime);
        waitForElements(total_prices, waitTime);

        for (int i = 0; i < item_prices.size(); i++)
            total_price_on_cart += Float.valueOf(item_quantities.get(i).getText())
                    * Float.valueOf(item_prices.get(i).getText().replace("$", ""));

        for (WebElement total_price : total_prices)
            if (total_price_on_cart != Float.valueOf(total_price.getText().replace("$", ""))) {
                Reporter.addStepLog("The total price on the cart is NOT correct, total calculated price is: $"
                        + total_price_on_cart
                        + " but the cart price is: "
                        + total_price.getText());
                captureScreenshot();

                return false;
            }

        Reporter.addStepLog("The total price on the cart is correct: $" + total_price_on_cart);
        captureScreenshot();
        return true;
    }

    public boolean checkQuantityOnCart() throws IOException {
        int total_quantity_on_cart = 0;

        for (WebElement item_quantity : item_quantities)
            total_quantity_on_cart += Integer.valueOf(item_quantity.getText());

        List<WebElement> total_quantities_on_cart = baseActionsDriver.findElements(By.xpath("//span[contains(text(), '" + total_quantity_on_cart + " item') or contains(text(), '" + total_quantity_on_cart + " items')]"));

        if (total_quantities_on_cart.size() == 0) {
            Reporter.addStepLog("The total quantity on the cart is NOT correct: $" + total_quantity_on_cart);
            captureScreenshot();
            return false;
        }

        Reporter.addStepLog("The total quantity on the cart is correct: $" + total_quantity_on_cart);
        captureScreenshot();
        return true;
    }

    public void ClickOnProceedToCheckoutButton() throws IOException {
        click(proceed_to_checkout_button);
    }
}