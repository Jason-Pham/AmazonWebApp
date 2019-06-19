package actions;

import helpers.DriverFactory;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseActions {
    protected WebDriver baseActionsDriver;

    public BaseActions() {
        baseActionsDriver = Hooks.driver;
    }
}
