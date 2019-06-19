package step_definitions.ProductPageSteps;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import step_definitions.BaseSteps;

import java.io.IOException;

public class ProductPageSteps extends BaseSteps {
    @And("^User adds \"([^\"]*)\" items to cart$")
    public void userAddNumberOfProductToCart(int numberOfProduct) throws IOException {
        productPageActions.ExecuteAddToCart(numberOfProduct);
    }

    @Then("^User go back to home page$")
    public void userGoBackToHomePage() throws IOException {
        productPageActions.GoToHomePage();
        Assert.assertTrue(homePageActions.UserIsInHomePage(), "User is in Home Page");
        Reporter.addStepLog("User is in Home Page");
    }
}
