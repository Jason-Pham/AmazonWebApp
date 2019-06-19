package helpers;

import com.vimalselvam.cucumber.listener.Reporter;
import helpers.ReportHelper.PrintLog;
import helpers.ReportHelper.ScreenshotHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Utils {

    private static long waitTime = 15;

    private static void captureScreenshot() throws IOException {
        Reporter.addScreenCaptureFromPath(ScreenshotHelper.takeScreenshot(Hooks.driver,
                LocalDateTime.now().getHour()
                        + LocalDateTime.now().getMinute()
                        + String.valueOf(LocalDateTime.now().getSecond())));
    }
    
    public static String ExtentEmailByGetTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long ExtentEmail = timestamp.getTime();
        return Long.toString(ExtentEmail);
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

    public static void clickWithoutWait(WebElement element) throws IOException {
        try {
            element.click();
            PrintLog.printLogActionInPage("Clicked on element: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Click on element: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    private static void clear(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);

            element.clear();
            PrintLog.printLogActionInPage("Text area is cleared on this element: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Clear element: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void sendKeys(WebElement element, String keys) throws IOException {
        try {
            waitForElement(element, waitTime);
            clear(element);

            element.sendKeys(keys);
            PrintLog.printLogActionInPage(keys + " was sent to this element: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Send keys",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void sendKeysWithoutClearing(WebElement element, String keys) throws IOException {
        try {
            waitForElement(element, waitTime);

            element.sendKeys(keys);
            PrintLog.printLogActionInPage(keys + " was sent to this element: " + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Send keys",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void sendKeysWithoutClearingAndWaiting(WebElement element, String keys) throws IOException {
        try {
            waitForElement(element, waitTime);

            element.sendKeys(keys);
            PrintLog.printLogActionInPage(keys + " was sent to this element: " + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Send keys",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void moveToElement(WebElement element) throws IOException {
        try {
            Actions actions = new Actions(Hooks.driver);
            actions.moveToElement(element);
            actions.perform();

            PrintLog.printLogActionInPage("Move to element: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Move to element: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void waitForTitleLoad(String title) throws IOException {
        try {
            PrintLog.printLogActionInPage("Wait until title visible: \n" + title);

            WebDriverWait wait = new WebDriverWait(Hooks.driver, waitTime);
            wait.until(ExpectedConditions.titleIs(title));
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Wait until element visible: \n",
                    title, e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void hoverOnElement(WebElement element) throws IOException {
        try {
            waitForElement(element, waitTime);

            Actions hover_account_icon = new Actions(Hooks.driver);
            hover_account_icon.moveToElement(element).build().perform();

            PrintLog.printLogActionInPage("Hover on this element: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Element is NOT hovered: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    private static String subString(String originalString, String headString, String endString) {
        return originalString.replaceAll(headString, "")
                .replaceAll(endString, "");
    }

    public static <T> T getRandomItem(List<T> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void selectDropdownOptionById(WebElement element, String dropDownOption) throws IOException {
        try {
            waitForElement(element, waitTime);
            click(element);
            String dropDownElement = subString(element.getAttribute("id"), "", "value");
            String xpathDropDownOption = dropDownElement + dropDownOption;
            Hooks.driver.findElement(By.id(xpathDropDownOption)).click();

            PrintLog.printLogActionInPage("This element is selected: \n" + element.toString());
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("This element is NOT selected: \n",
                    element.toString(), e.getMessage());

            captureScreenshot();

            Assert.fail();
        }

    }

    public static void scrollToView(int x, int y) throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
            js.executeScript("javascript:window.scrollBy(" + x + "," + y + ")");

            PrintLog.printLogActionInPage("Move to: \n" + x + "-" + y);
        } catch (NullPointerException | WebDriverException e) {
            PrintLog.printLogErrorActionOfElement("Move to view: \n",
                    x + "-" + y, e.getMessage());

            captureScreenshot();

            Assert.fail();
        }
    }

    public static void threadSleep(int time) throws InterruptedException {
        PrintLog.printLogActionInPage("Sleep for: \n" + time + " milliseconds");

        Thread.sleep(time);
    }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    PrintLog.printLogActionInPage("File is deleted: " +
                            f.getName() + " - " + f.delete());
                }
            }
        }
        PrintLog.printLogActionInPage("Folder is deleted: " +
                folder.getName() + " - " + folder.delete());
    }

    public static void scrollToElementInADiv(WebElement divElement, WebElement scrollToElement){
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",
                divElement,
                scrollToElement);
    }

    public static void reloadThePage(){
        Hooks.driver.navigate().refresh();
    }

    public static void waitForPageToLoad(){
        new WebDriverWait(Hooks.driver, waitTime + 15).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}