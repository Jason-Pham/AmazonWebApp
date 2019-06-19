package actions.ProductPage;

import actions.BaseActions;
import com.vimalselvam.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;
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

    private boolean ChooseSize() throws IOException {
        if(CheckProductSizeDropBox()){
            ExecuteClickOnProductSizeDropBox();
            if(available_product_sizes.size() == 0) {
                Assert.assertTrue(true,"All product sizes are out of stocks");
                Reporter.addStepLog("All product sizes are out of stocks");
                return false;
            }
            else {
                click(available_product_sizes.get(new Random().nextInt(available_product_sizes.size())));
                return true;
            }
        }
        else
            return true;
    }

    private void ChooseQuantity(int numberOfProduct) throws IOException {
        click(quantity_dropbox);
        click(baseActionsDriver.findElement(By.xpath("//select[@id='quantity']//child::option["+ numberOfProduct +"]")));
    }

    public void ExecuteAddToCart(int numberOfProduct) throws IOException {
        waitForPageToLoad();
        if(ChooseSize())
            if(numberOfProduct > quantity_dropbox_options.size()) {
                Assert.assertTrue(true, "Product does not have enough stocks to add: " + numberOfProduct);
                Reporter.addStepLog("Product does not have enough stocks to add: " + numberOfProduct);
            }
            else {
                ChooseQuantity(numberOfProduct);
                click(add_to_cart_button);
                Assert.assertFalse(proceed_to_checkout.isEmpty(), "Add to cart failed");
            }
    }

    public void GoToHomePage() throws IOException {
        click(home_page_logo);
    }
}