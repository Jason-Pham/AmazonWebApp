package page_objects.ProductPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class ProductPage extends BaseClass {

    public ProductPage(org.openqa.selenium.WebDriver driver) {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "native_dropdown_selected_size_name")
    public List<WebElement> product_size_dropbox;

    @FindBy(how = How.XPATH, using = "//option[contains(@id, 'native_size_name_') and @data-a-css-class='dropdownAvailable']")
    public List<WebElement> available_product_sizes;

    @FindBy(how = How.XPATH, using = "//*[@id='add-to-cart-button' or @id='mbc-buybutton-addtocart-1-announce']")
    public WebElement add_to_cart_button;

    @FindBy(how = How.ID, using = "quantity")
    public WebElement quantity_dropbox;

    @FindBy(how = How.XPATH, using = "//select[@id='quantity']//child::option")
    public List<WebElement> quantity_dropbox_options;

    @FindBy(how = How.ID, using = "hlb-ptc-btn-native")
    public List<WebElement> proceed_to_checkout;

    @FindBy(how = How.ID, using = "nav-logo-sprites")
    public WebElement home_page_logo;

    @FindBy(how = How.XPATH, using = "//*[@id='mbc-price-1' or @id='priceblock_dealprice' or @id='priceblock_ourprice' or @class='a-price' or @class='a-offscreen' or contains(@class, 'a-price')]//span[contains(@class,'a-offscreen')] | //*[@id='mbc-price-1' or @id='priceblock_dealprice' or @id='priceblock_ourprice'] | //span[contains(@class, 'a-price')]//span[contains(@class, 'a-offscreen')]")
    public List<WebElement> product_price_text;

    @FindBy(how = How.XPATH, using = "//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    public List<WebElement> total_price_text;

    @FindBy(how = How.XPATH, using = "//*[@id='sw-gtc']//a | //*[@id='hlb-view-cart-announce'] | //*[@id='nav-cart']")
    public WebElement cart_button;
}
