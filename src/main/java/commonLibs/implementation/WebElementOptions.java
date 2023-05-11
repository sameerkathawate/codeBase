package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementOptions {
    WebDriver driver;

    public WebElementOptions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendText(WebElement element, String text) {
        element.isDisplayed();
        element.sendKeys(text);

    }
    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public void selectVisibleDropdownValue(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void findByValueDropdownElement(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(text);

    }



}
