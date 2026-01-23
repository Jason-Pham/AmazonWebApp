package step_definitions.HomePageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
        if (buttonText.equalsIgnoreCase("Best Sellers")) {
            baseStepsDriver.navigate().to("https://www.amazon.com/gp/bestsellers/?ref_=nav_cs_bestsellers");
        } else {
            homePageActions.ExecuteClickOnSignInLinkWithText(buttonText);
        }
    }
}
