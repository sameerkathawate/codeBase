package com.seleniumtest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void verifyHappyPathLogin(){

        String username = config.getProperty("username");
        String password = config.getProperty("password");

        loginPage.loginTest(username, password);
        String title = "";
        String actualTitle = cmnDriver.getTitle();
        Assert.assertEquals(actualTitle, title);

    }
}


