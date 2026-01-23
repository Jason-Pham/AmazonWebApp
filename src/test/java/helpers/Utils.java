package helpers;

import helpers.ReportHelper.ScreenshotHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Utils {
    public static float totalPrice = 0;
    public static int totalItem = 0;
    public static long waitTime = 15;

    public static void captureScreenshot() throws IOException {
        ScreenshotHelper.takeScreenshot(DriverFactory.getInstance().getDriver(),
                LocalDateTime.now().getHour()
                        + LocalDateTime.now().getMinute()
                        + String.valueOf(LocalDateTime.now().getSecond()));
    }

    private static void waitForElement(WebElement element, long time) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(time));
            wait.until(elementToBeClickable(element));
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            System.out.println("Waiting for this element is failed: " + element);
            Assert.fail();
        }
    }

    public static void waitForElements(List<WebElement> elements, long time) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(time));
            for (WebElement element : elements)
                wait.until(elementToBeClickable(element));
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Assert.fail();
        }
    }

    public static void click(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);
            element.click();
            captureScreenshot();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            System.out.println("Clicking in this element is failed: " + element);
            Assert.fail("");
        }
    }

    private static void clear(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);
            element.clear();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Assert.fail();
        }
    }

    public static void sendKeys(WebElement element, String keys) throws IOException {
        try {
            waitForElement(element, waitTime);
            clear(element);
            element.sendKeys(keys);
            captureScreenshot();
        } catch (NullPointerException | WebDriverException e) {
            captureScreenshot();
            Assert.fail();
        }
    }

    public static void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Scrolling to element failed: " + element);
        }
    }

    public static void waitForPageToLoad() {
        new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(waitTime + 15)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }
}