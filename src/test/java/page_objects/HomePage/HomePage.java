package page_objects.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class HomePage extends BaseClass {

    public HomePage(org.openqa.selenium.WebDriver driver) {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "desktop-banner")
    public List<WebElement> home_page_banners;

    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    public WebElement search_box;

    @FindBy(how = How.ID, using = "nav-search-submit-button")
    public WebElement search_button;
}
