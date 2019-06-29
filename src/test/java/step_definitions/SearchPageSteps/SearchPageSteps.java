package step_definitions.SearchPageSteps;

import cucumber.api.java.en.And;
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