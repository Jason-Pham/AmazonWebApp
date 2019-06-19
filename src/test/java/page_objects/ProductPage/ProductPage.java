package page_objects.ProductPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class ProductPage extends BaseClass {
    @FindBy(how = How.ID, using = "native_dropdown_selected_size_name")
    public static List<WebElement> product_size_dropbox;

    @FindBy(how = How.XPATH, using = "//option[contains(@id, 'native_size_name_') and @data-a-css-class='dropdownUnavailable']")
    public static List<WebElement> available_product_sizes;

    @FindBy(how = How.ID, using = "add-to-cart-button")
    public static WebElement add_to_cart_button;

    @FindBy(how = How.ID, using = "quantity")
    public static WebElement quantity_dropbox;

    @FindBy(how = How.XPATH, using = "//select[@id='quantity']//child::option")
    public static List<WebElement> quantity_dropbox_options;

    @FindBy(how = How.ID, using = "hlb-ptc-btn-native")
    public static List<WebElement> proceed_to_checkout;

    @FindBy(how = How.XPATH, using = " //a[@class='nav-logo-link']")
    public static WebElement home_page_logo;
}
