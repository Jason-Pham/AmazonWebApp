package page_objects;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass() {
        driver = helpers.DriverFactory.getInstance().getDriver();
    }
}
