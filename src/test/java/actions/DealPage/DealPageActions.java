package actions.DealPage;

import actions.BaseActions;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Random;

import static helpers.Utils.click;
import static page_objects.DealPage.DealPage.deal_items;
import static page_objects.DealPage.DealPage.sort_dropdown_box;

public class DealPageActions extends BaseActions {

    public void ExecuteClickOnSortButton() throws IOException {
        click(sort_dropdown_box);
    }

    public void ExecuteClickOnSortButtonType(String sortType) throws IOException {
        click(baseActionsDriver.findElement(By.xpath("//a[contains(text(), '"+ sortType +"')]")));
    }

    public void ExecuteClickOnDeal(int dealNumber) throws IOException {
        click(baseActionsDriver.findElement(
                By.xpath("((//div[contains(@id, '101_dealView_')])//child::a[contains(text(), " +
                        "'View Deal')])["+dealNumber+"]")));
    }

    public void ExecuteClickOnDealItem() throws IOException {
        if(deal_items.size() > 0)
            click(deal_items.get(new Random().nextInt(deal_items.size()) - 1));
    }
}
