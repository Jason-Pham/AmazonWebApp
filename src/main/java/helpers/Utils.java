package helpers;

import com.vimalselvam.cucumber.listener.Reporter;
import helpers.ReportHelper.PrintLog;
import helpers.ReportHelper.ScreenshotHelper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Utils {
    public static float totalPrice = 0;
    public static int totalItem = 0;
    private static long waitTime = 15;

    public static void captureScreenshot() throws IOException {
        Reporter.addScreenCaptureFromPath(ScreenshotHelper.takeScreenshot(Hooks.driver,
                LocalDateTime.now().getHour()
                        + LocalDateTime.now().getMinute()
                        + String.valueOf(LocalDateTime.now().getSecond())));
    }

    private static void waitForElement(WebElement element, long time) throws IOException {
        try {
            PrintLog.printLogActionInPage("Wait for element: \n" + element.toString());

            WebDriverWait wait = new WebDriverWait(Hooks.driver, time);
            wait.until(elementToBeClickable(element));
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("This element is not available: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();
            Assert.fail();
        }
    }

    public static void click(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);

            element.click();
            PrintLog.printLogActionInPage("Clicked on element: \n" + element.toString());

            captureScreenshot();
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Click on element: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void waitForPageToLoad(){
        new WebDriverWait(Hooks.driver, waitTime + 15).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}