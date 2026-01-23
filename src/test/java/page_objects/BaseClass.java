package page_objects;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {

    public WebDriver getDriver() {
        return helpers.DriverFactory.getInstance().getDriver();
    }
}
