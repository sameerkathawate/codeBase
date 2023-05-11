package com.seleniumtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @CacheLookup
    @FindBy(name = "uid")
    private WebElement userId;

    @CacheLookup
    @FindBy(name="password")
    private WebElement userPwd;

    @CacheLookup
    @FindBy(name="btnLogin")
    private WebElement loginButton;


    public LoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void loginTest(String username, String password) {
        element.sendText(userId, username);
        element.sendText(userPwd, password);
        element.clickElement(loginButton);
    }

}
