package page_objects.CartPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class CartPage extends BaseClass {

    public CartPage(org.openqa.selenium.WebDriver driver) {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//select[@name='quantity']")
    public List<WebElement> quantity_dropbox;

    @FindBy(how = How.XPATH, using = "//input[@name='quantityBox']")
    public List<WebElement> quantity_inputs;

    @FindBy(how = How.XPATH, using = "//input[@value='Delete'] | //input[@data-action='delete']")
    public List<WebElement> delete_buttons;

    @FindBy(how = How.XPATH, using = "//*[@name='proceedToRetailCheckout'] | //*[@name='proceedToCheckout']")
    public WebElement proceed_to_checkout_button;

    @FindBy(how = How.XPATH, using = "//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap  sc-price-sign' "
            +
            "or @class = 'a-size-medium a-color-price sc-price sc-white-space-nowrap sc-price-sign']")
    public List<WebElement> total_prices;

    @FindBy(how = How.XPATH, using = "//span[@class = 'a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']")
    public List<WebElement> item_prices;

    @FindBy(how = How.CLASS_NAME, using = "a-dropdown-prompt")
    public List<WebElement> item_quantities;
}
