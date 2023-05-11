package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommonDriver {

    private WebDriver driver;
    private Integer pageLoadTimeout;

    private Integer elementTimeout;
    private String currentDirectory;

    public CommonDriver() {
        currentDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentDirectory+"/drivers/chromedriver");
        driver = new ChromeDriver();

        //set default values for page and element load times in seconds.
        pageLoadTimeout = 15;
        elementTimeout = 10;

        //set timeouts
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementTimeout, TimeUnit.SECONDS);

        //Maximize the browser window and clear cookies.
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public void updateTimeouts() {
        //set timeouts for browser
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementTimeout, TimeUnit.SECONDS);
    }

    public void openUrl(String url) {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(elementTimeout, TimeUnit.SECONDS);

        driver.get(url);
    }

    public void closeAllBrowser() {
        driver.quit();
    }


    public void setPageLoadTimeout(Integer pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElementTimeout(Integer elementTimeout) {
        this.elementTimeout = elementTimeout;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
