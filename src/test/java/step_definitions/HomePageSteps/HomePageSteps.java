package step_definitions.HomePageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.Constant;
import helpers.TestData.UrlEnvInfo;
import step_definitions.BaseSteps;

public class HomePageSteps extends BaseSteps {

    @Given("^User is opening Amazon home page$")
    public void userIsOpeningAmazonHomePage() {
        if (Constant.Environment != null)
            baseStepsDriver.navigate().to(Constant.Environment);
        else
            baseStepsDriver.navigate().to(UrlEnvInfo.amazon_au_prod);
    }

    @And("^User search for \"([^\"]*)\"$")
    public void useSearch(String searchText) throws Throwable {
        homePageActions.Search(searchText);
    }

    @When("^User clicks on \"([^\"]*)\" button$")
    public void userClicksOnButton(String buttonText) throws Throwable {
        homePageActions.ExecuteClickOnSignInLinkWithText(buttonText);
    }
}
