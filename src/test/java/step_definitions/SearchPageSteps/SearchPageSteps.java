package step_definitions.SearchPageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.Constant;
import helpers.TestData.UrlEnvInfo;
import step_definitions.BaseSteps;

public class SearchPageSteps extends BaseSteps {
    @And("^User sort the search items by \"([^\"]*)\"$")
    public void Sort(String sortType) throws Throwable {
        searchPageActions.Sort(sortType);
    }

    @And("^User view the product on the \"([^\"]*)\" item search$")
    public void GoToSearchItemNumber(int searchItemNumber) throws Throwable {
        searchPageActions.GoToSearchItemNumber(searchItemNumber);
    }
}
