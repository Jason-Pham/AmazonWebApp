package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import helpers.DriverFactory;
import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ServiceHooks {

    @Before
    public void initializeTest() {
        PrintLog.printLogActionInPage("Starting Scenario");

        // Ensure browser is configured
        org.openqa.selenium.WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                if (DriverFactory.getInstance().getDriver() != null) {
                    final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "screenshot");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        PrintLog.printLogActionInPage("Closing browser for scenario: " + scenario.getName());
        if (DriverFactory.getInstance().getDriver() != null) {
            DriverFactory.getInstance().removeDriver();
        }
    }
}
