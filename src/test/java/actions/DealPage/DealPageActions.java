package actions.DealPage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Random;

import static helpers.Utils.click;

public class DealPageActions extends BaseActions {

    page_objects.DealPage.DealPage dealPage = new page_objects.DealPage.DealPage(driver);

    public void ExecuteClickOnSortButton() throws IOException {
        click(dealPage.sort_dropdown_box);
    }

    public void ExecuteClickOnSortButtonType(String sortType) throws IOException {
        click(driver.findElement(By.xpath("(//*[contains(text(), '" + sortType + "')])[3]")));
    }

    public void ExecuteClickOnDeal(int dealNumber) throws IOException {
        click(driver.findElement(
                By.xpath("(//*[contains(@class, 'a-spacing-mini')])[" + dealNumber + "]")));
    }

    public void ExecuteClickOnDealItem() throws IOException {
        if (dealPage.deal_items.size() > 0)
            click(dealPage.deal_items.get(new Random().nextInt(dealPage.deal_items.size()) - 1));
    }
}
