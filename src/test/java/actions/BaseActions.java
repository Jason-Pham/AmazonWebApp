package actions;

import org.openqa.selenium.WebDriver;

public abstract class BaseActions {
    protected WebDriver driver;

    public BaseActions() {
        this.driver = helpers.DriverFactory.getInstance().getDriver();
    }
}
