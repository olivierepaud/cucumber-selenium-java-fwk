package com.csjfwk.wknd.utils;

import org.openqa.selenium.WebDriver;
import com.csjfwk.wknd.pageObjects.PageObjectsManager;

//import java.io.IOException;

public class TestContextSetup {
    
    public WebDriver webDriver;
    public PageObjectsManager pageObjectsManager;
    public WebDriverSetup webDriverSetup;
    public WebDriverUtils webDriverUtils;

    public TestContextSetup() {
        System.out.println("***/!\\*** 1. in TestContextSetup() constructor (auto call)");
        System.out.println("***/!\\***    we instanciate the webDriver and the page objects manager in the class");
        webDriverSetup = new WebDriverSetup();
        webDriver = webDriverSetup.WebDriverManager();
        pageObjectsManager = new PageObjectsManager(webDriver);
        webDriverUtils = new WebDriverUtils(webDriver);
    }

}
