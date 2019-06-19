package helpers;

import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        String browser = Constant.Browser;
        if (browser == null) {

            browser = System.getenv("Browser");
            if (browser == null) {
                browser = "chrome";
            }
        }

        driver = DriverFactory.getInstance().getDriver();

        PrintLog.printLogActionInPage("Open browser: " + browser);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void embedScreenshot() {
        PrintLog.printLogActionInPage("Close browser: " + Constant.Browser);
        DriverFactory.getInstance().removeDriver();
    }
}