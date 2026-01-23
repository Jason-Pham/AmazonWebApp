package page_objects.SearchPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

public class SearchPage extends BaseClass {

    public SearchPage(org.openqa.selenium.WebDriver driver) {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='a-button-text a-declarative']")
    public WebElement sort_dropbox;
}
