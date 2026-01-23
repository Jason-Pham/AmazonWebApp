package page_objects.SignInPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import page_objects.BaseClass;

import java.util.List;

public class SignInPage extends BaseClass {

    public SignInPage(org.openqa.selenium.WebDriver driver) {
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Sign-In')]")
    public List<WebElement> sign_in_text;

    @FindBy(how = How.XPATH, using = "//input[@id = 'ap_email']")
    public List<WebElement> email_input;

    @FindBy(how = How.XPATH, using = "//input[@id = 'ap_password']")
    public List<WebElement> password_input;

    @FindBy(how = How.XPATH, using = "//input[@id = 'signInSubmit']")
    public List<WebElement> sign_in_button;
}
