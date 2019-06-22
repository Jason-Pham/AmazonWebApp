package helpers;

import helpers.ReportHelper.PrintLog;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @BeforeTest
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
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void embedScreenshot() {
        PrintLog.printLogActionInPage("Close browser: " + Constant.Browser);
        DriverFactory.getInstance().removeDriver();
    }
}