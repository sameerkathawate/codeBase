package com.seleniumtest.tests;

import com.seleniumtest.pages.LoginPage;
import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    CommonDriver cmnDriver;
    String url;
    WebDriver driver;
    LoginPage loginPage;
    ConfigUtils config;
    ScreenshotUtils screenshot;

    @BeforeClass
    public void setup() throws Exception {

        config = new ConfigUtils();
        cmnDriver = new CommonDriver();
        driver = cmnDriver.getDriver();

        url = config.getProperty("url");
        cmnDriver.openUrl(url);

        loginPage = new LoginPage(driver);
        screenshot = new ScreenshotUtils(driver);
    }

    @AfterMethod
    public void postTestAction(ITestResult result) throws Exception {

        String testcase = result.getName();
        long execTime = System.currentTimeMillis();
        String currDir = System.getProperty("user.dir");
        String fileName = currDir+"/screenshots/"+testcase+execTime+".jpeg";

        if(result.getStatus() == ITestResult.FAILURE) {
            screenshot.captureScreenshot(fileName);
        }
    }

    @AfterClass
    public void teardown() {
        cmnDriver.closeAllBrowser();
    }
}
