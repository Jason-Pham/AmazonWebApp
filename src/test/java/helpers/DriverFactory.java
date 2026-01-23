package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    // protected WebDriver driver;

    private DriverFactory() {
        // Do-nothing..Do not allow to initializethis class from outside
    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        ChromeOptions options = new ChromeOptions();
        if (Constant.Headless)
            options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-setuid-sandbox");
        return new ChromeDriver(options);
    });

    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public void removeDriver() // Quits the driver and closes the browser
    {
        driver.get().quit();
        driver.remove();
    }
}