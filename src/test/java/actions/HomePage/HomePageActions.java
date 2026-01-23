package actions.HomePage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class HomePageActions extends BaseActions {

    page_objects.HomePage.HomePage homePage = new page_objects.HomePage.HomePage(baseActionsDriver);

    public boolean UserIsInHomePage() {
        return homePage.home_page_banners.size() != 0;
    }

    public void ExecuteClickOnSignInLinkWithText(String text) throws IOException {
        try {
            click(baseActionsDriver.findElement(By.linkText(text)));
        } catch (Exception e) {
            click(baseActionsDriver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")));
        }
    }

    public void Search(String searchText) throws IOException {
        sendKeys(homePage.search_box, searchText);
        click(homePage.search_button);
    }
}