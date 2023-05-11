package com.seleniumtest.pages;

import commonLibs.implementation.WebElementOptions;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public WebElementOptions element;

    BasePage(WebDriver driver){
        this.driver = driver;
        element = new WebElementOptions(driver);
    }

}
