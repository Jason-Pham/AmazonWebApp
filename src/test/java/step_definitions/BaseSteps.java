package step_definitions;

import actions.CartPage.CartPageActions;
import actions.DealPage.DealPageActions;
import actions.HomePage.HomePageActions;
import actions.ProductPage.ProductPageActions;
import actions.SearchPage.SearchPageActions;
import actions.SignInPage.SignInPageActions;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected WebDriver driver;
    protected HomePageActions homePageActions = new HomePageActions();
    protected DealPageActions dealPageActions = new DealPageActions();
    protected ProductPageActions productPageActions = new ProductPageActions();
    protected SearchPageActions searchPageActions = new SearchPageActions();
    protected CartPageActions cartPageActions = new CartPageActions();
    protected SignInPageActions signInPageActions = new SignInPageActions();

    public BaseSteps() {
        this.driver = helpers.DriverFactory.getInstance().getDriver();
    }
}
