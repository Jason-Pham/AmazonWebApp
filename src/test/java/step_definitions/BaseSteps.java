package step_definitions;

import actions.CartPage.CartPageActions;
import actions.DealPage.DealPageActions;
import actions.HomePage.HomePageActions;
import actions.ProductPage.ProductPageActions;
import actions.SearchPage.SearchPageActions;
import actions.SignInPage.SignInPageActions;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.CartPage.CartPage;
import page_objects.DealPage.DealPage;
import page_objects.HomePage.HomePage;
import page_objects.ProductPage.ProductPage;
import page_objects.SearchPage.SearchPage;
import page_objects.SignInPage.SignInPage;

public class BaseSteps {

    protected WebDriver baseStepsDriver;
    protected HomePageActions homePageActions = new HomePageActions();
    protected DealPageActions dealPageActions = new DealPageActions();
    protected ProductPageActions productPageActions = new ProductPageActions();
    protected SearchPageActions searchPageActions = new SearchPageActions();
    protected CartPageActions cartPageActions = new CartPageActions();
    protected SignInPageActions signInPageActions = new SignInPageActions();

    public BaseSteps() {
        baseStepsDriver = helpers.DriverFactory.getInstance().getDriver();

    }
}
