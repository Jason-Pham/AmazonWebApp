package actions.SearchPage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;
import static page_objects.HomePage.HomePage.*;
import static page_objects.SearchPage.SearchPage.sort_dropbox;

public class SearchPageActions extends BaseActions {
    public void Sort(String searchText) throws IOException {
        click(sort_dropbox);
        click(baseActionsDriver.findElement
                (By.xpath("//a[contains(@id, 's-result-sort-select') and text()='" + searchText + "']")));
    }

    public void GoToSearchItemNumber(int searchItemNumber) throws IOException {
        click(baseActionsDriver.findElement
                (By.xpath("(//a[@class='a-link-normal a-text-normal'])[" + searchItemNumber + "]")));
    }
}