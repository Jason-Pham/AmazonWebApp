package _runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import helpers.Constant;
import helpers.DriverFactory;
import helpers.Hooks;
import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

@CucumberOptions(features = "src/test/resources/features", tags = "@Search", plugin = { "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json" }, glue = "step_definitions")

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void openBrowser() {
        String browser = helpers.Constant.Browser;
        if (browser == null) {
            browser = System.getenv("Browser");
            if (browser == null) {
                browser = "chrome";
            }
        }

        WebDriver driver = DriverFactory.getInstance().getDriver();

        PrintLog.printLogActionInPage("Open browser: " + browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Override
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest
    public void embedScreenshot() {
        PrintLog.printLogActionInPage("Close browser: " + helpers.Constant.Browser);
        if (DriverFactory.getInstance().getDriver() != null) {
            DriverFactory.getInstance().removeDriver();
        }
    }
}
