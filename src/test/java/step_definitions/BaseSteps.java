package step_definitions;

import actions.DealPage.DealPageActions;
import actions.HomePage.HomePageActions;
import actions.ProductPage.ProductPageActions;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.DealPage.DealPage;
import page_objects.HomePage.HomePage;
import page_objects.ProductPage.ProductPage;

public class BaseSteps {

    protected WebDriver baseStepsDriver;
    protected HomePageActions homePageActions = new HomePageActions();
    protected DealPageActions dealPageActions = new DealPageActions();
    protected ProductPageActions productPageActions = new ProductPageActions();

    public BaseSteps() {
        baseStepsDriver = Hooks.driver;
        PageFactory.initElements(baseStepsDriver, HomePage.class);
        PageFactory.initElements(baseStepsDriver, DealPage.class);
        PageFactory.initElements(baseStepsDriver, ProductPage.class);
    }
}
