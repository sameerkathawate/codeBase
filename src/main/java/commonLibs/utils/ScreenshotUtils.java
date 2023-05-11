package commonLibs.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    private TakesScreenshot print;
    public ScreenshotUtils(WebDriver driver) {
        print = (TakesScreenshot) driver;
    }

    public void captureScreenshot(String filename) throws Exception {
        filename = filename.trim();
        File imgFile, tmpFile;
        imgFile = new File(filename);
        if(imgFile.exists()) {
            throw new Exception("File already exists");
        }

        tmpFile = print.getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(tmpFile, imgFile);
    }
}
