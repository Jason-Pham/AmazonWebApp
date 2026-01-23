package actions.SearchPage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;

import static helpers.Utils.click;

public class SearchPageActions extends BaseActions {

    page_objects.SearchPage.SearchPage searchPage = new page_objects.SearchPage.SearchPage(driver);

    public void Sort(String searchText) throws IOException {
        click(searchPage.sort_dropbox);
        click(driver
                .findElement(By.xpath("//a[contains(@id, 's-result-sort-select') and text()='" + searchText + "']")));
    }

    public void GoToSearchItemNumber(int searchItemNumber) throws IOException {
        org.openqa.selenium.WebElement searchItem = driver
                .findElement(
                        By.xpath(
                                "(//div[@data-component-type='s-search-result' and not(contains(@class, 'AdHolder'))]//a[contains(@class, 'a-link-normal') and contains(@class, 'a-text-normal')])["
                                        + searchItemNumber + "]"));
        helpers.Utils.scrollToElement(searchItem);
        click(searchItem);
    }
}