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

    private ThreadLocal<WebDriver> driver;

    {
        // thread local driver object for webdriver
        driver = ThreadLocal.withInitial(() -> {
            // WebDriverManager.chromedriver().setup(); // Not needed in Selenium 4
            ChromeOptions options = new ChromeOptions();
            if (Constant.Headless)
                options.addArguments("--headless");
            // options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--incognito");
            options.addArguments("--no-sandbox");
            options.addArguments("--window-size=1920,1080");
            // options.addArguments("–disable-dev-shm-usage");
            options.addArguments("start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-setuid-sandbox");
            return new ChromeDriver(options); // can be replaced with other browser drivers
        });
    }

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