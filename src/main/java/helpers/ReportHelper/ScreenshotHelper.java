package helpers.ReportHelper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    private static String separator = System.getProperty("file.separator");
    private static String directory = System.getProperty("user.dir")
            + separator + "target"
            + separator + "Amazon-reports"
            + separator + "screenshots"
            + separator;

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        return "." + separator + "screenshots" + separator + fileName;
    }
}