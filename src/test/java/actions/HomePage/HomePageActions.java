package actions.HomePage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;
import static page_objects.HomePage.HomePage.*;

public class HomePageActions extends BaseActions {
    public boolean UserIsInHomePage() {
        return home_page_banners.size() != 0;
    }

    public void ExecuteClickOnSignInLinkWithText(String text) throws IOException {
        click(baseActionsDriver.findElement(By.linkText(text)));
    }

    public void Search(String searchText) throws IOException {
        sendKeys(search_box, searchText);
        click(search_button);
    }
}