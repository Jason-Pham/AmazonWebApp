package step_definitions.ProductPageSteps;

import helpers.ReportHelper.PrintLog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import step_definitions.BaseSteps;

import java.io.IOException;

public class ProductPageSteps extends BaseSteps {
    @And("^User adds \"([^\"]*)\" items to cart$")
    public void userAddNumberOfProductToCart(int numberOfProduct) throws IOException {
        productPageActions.ExecuteAddToCart(numberOfProduct);
    }

    @When("^User go to cart$")
    public void userGoToCart() throws IOException {
        productPageActions.ClickOnCartButton();
    }

    @Then("^User go back to home page$")
    public void userGoBackToHomePage() throws IOException {
        productPageActions.GoToHomePage();
        Assert.assertTrue(homePageActions.UserIsInHomePage(), "User is in Home Page");
        PrintLog.printLogActionInPage("User is in Home Page");
    }
}