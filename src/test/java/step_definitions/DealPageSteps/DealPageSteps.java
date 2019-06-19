package step_definitions.DealPageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.Constant;
import helpers.TestData.UrlEnvInfo;
import step_definitions.BaseSteps;

import java.io.IOException;

public class DealPageSteps extends BaseSteps {
    @And("^User sort the items by \"([^\"]*)\"$")
    public void userSortTheItemBy(String sortType) throws IOException {
        dealPageActions.ExecuteClickOnSortButton();
        dealPageActions.ExecuteClickOnSortButtonType(sortType);
    }

    @And("^User view the deal on the \"([^\"]*)\" item$")
    public void userViewTheItemBy(String dealNumber) throws IOException {
        dealPageActions.ExecuteClickOnDeal(dealNumber);
    }
}
