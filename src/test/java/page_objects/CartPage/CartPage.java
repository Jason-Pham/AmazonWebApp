package page_objects.CartPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class CartPage extends BaseClass {
    @FindBy(how = How.XPATH, using = "//span[@class='a-button-text a-declarative']")
    public static List<WebElement> quantity_dropbox;

    @FindBy(how = How.XPATH, using = "//input[@value='Delete']")
    public static List<WebElement> delete_buttons;

    @FindBy(how = How.NAME, using = "proceedToCheckout")
    public static WebElement proceed_to_checkout_button;

    @FindBy(how = How.XPATH, using = "//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap  sc-price-sign' " +
                                    "or @class = 'a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']")
    public static List<WebElement> total_prices;

    @FindBy(how = How.XPATH, using = "//span[@class = 'a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']")
    public static List<WebElement> item_prices;

    @FindBy(how = How.CLASS_NAME, using = "a-dropdown-prompt")
    public static List<WebElement> item_quantities;


}
