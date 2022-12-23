package com.csjfwk.wknd.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.csjfwk.wknd.pageObjects.PageObjectsManager;

//import java.io.IOException;

public class TestContextSetup {
    
    public WebDriver webDriver;
    public WebDriverSetup webDriverSetup;
    public WebDriverUtils webDriverUtils;
    public PageObjectsManager pageObjectsManager;

    public TestContextSetup() {
        System.out.println("***/!\\*** 1. in TestContextSetup() constructor (auto call)");
        System.out.println("***/!\\***    we instanciate the webDriver and the page objects manager in the class");
        webDriverSetup = new WebDriverSetup();
        webDriver = webDriverSetup.WebDriverManager();
        webDriverUtils = new WebDriverUtils(webDriver);
        pageObjectsManager = new PageObjectsManager(webDriver);
    }

}
