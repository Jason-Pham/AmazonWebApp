package actions.HomePage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.click;
import static page_objects.HomePage.HomePage.home_page_banners;

public class HomePageActions extends BaseActions {
    public boolean UserIsInHomePage() {
        return home_page_banners.size() != 0;
    }

    public void ExecuteClickOnSignInLinkWithText(String text) throws IOException {
        click(baseActionsDriver.findElement(By.linkText(text)));
    }
}
