package page_objects.DealPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class DealPage extends BaseClass {

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Discount - High to Low')]")
    public static WebElement sort_discount_high_to_low;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Top Deals')]")
    public static WebElement sort_dropdown_box;

    @FindBy(how = How.XPATH, using = "//*[@class='a-section a-spacing-none oct-acs-asin-item-container' " +
            "or @class='a-section a-spacing-none a-inline-block s-position-relative' " +
            "or @class='s-result-item s-result-card-for-container a-declarative celwidget  ']")
    public static List<WebElement> deal_items;
}
