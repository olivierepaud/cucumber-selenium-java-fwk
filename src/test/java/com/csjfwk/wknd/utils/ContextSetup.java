package com.csjfwk.wknd.utils;

import org.openqa.selenium.WebDriver;
import com.csjfwk.wknd.pageObjects.PageObjectsManager;

//import java.io.IOException;

public class ContextSetup {
    
    public WebDriver webDriver;
    public PageObjectsManager pageObjectsManager;
    public WebDriverSetup webDriverSetup;
    public WebDriverUtils webDriverUtils;

    public void TestContextSetup() {
        webDriverSetup = new WebDriverSetup();
        webDriver = webDriverSetup.WebDriverManager();
        pageObjectsManager = new PageObjectsManager(webDriver);
        webDriverUtils = new WebDriverUtils(webDriver);
    }

}
