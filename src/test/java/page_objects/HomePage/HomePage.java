package page_objects.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class HomePage extends BaseClass {
    @FindBy(how = How.XPATH, using = "//div[@class='cropped-image-map-center-alignment']")
    public static List<WebElement> home_page_banners;

    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    public static WebElement search_box;

    @FindBy(how = How.XPATH, using = "//input[@type='submit' and @class='nav-input']")
    public static WebElement search_button;
}
