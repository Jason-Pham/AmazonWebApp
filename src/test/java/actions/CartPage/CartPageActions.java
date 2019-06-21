package actions.CartPage;

import actions.BaseActions;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.*;
import static page_objects.CartPage.CartPage.*;

public class CartPageActions extends BaseActions {
    public void DeleteItem(int numberOfItem) throws IOException {
        click(delete_buttons.get(numberOfItem - 1));
    }

    public void ChangeQuantity(int numberOfItem, int quantity) throws IOException{
        click(quantity_dropbox.get(numberOfItem - 1));

        click(baseActionsDriver.findElement
                (By.xpath("((//div[@class='a-popover a-dropdown a-dropdown-common a-declarative'])" +
                        "["+ numberOfItem +"]" +
                        "//child::li)" +
                        "["+quantity+"]")));

        Reporter.addStepLog("Change the product number: " + numberOfItem + " to: " + quantity + " item(s)");
        captureScreenshot();
    }

    public void ClickOnProceedToCheckoutButton() throws IOException {
        click(proceed_to_checkout_button);
    }
}