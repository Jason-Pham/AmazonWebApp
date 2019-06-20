package page_objects.SearchPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class SearchPage extends BaseClass {
    @FindBy(how = How.XPATH, using = "//span[@class='a-button-text a-declarative']")
    public static WebElement sort_dropbox;
}
