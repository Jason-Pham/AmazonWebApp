package page_objects;

import helpers.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    private WebDriver baseClassesDriver;

    public BaseClass() {
        baseClassesDriver = Hooks.driver;
    }
}
