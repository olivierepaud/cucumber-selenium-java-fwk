package com.csjfwk.wknd.utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

    public WebDriver webDriver;

    public WebDriverUtils(WebDriver driver) {
        System.out.println("***/!\\*** 4. in WebDriverUtils(WebDriver) constructor (from TestContextSetup)");
        webDriver = driver;
    }

    public void switchWindowToChild() {
        Set<String> strset = webDriver.getWindowHandles();
        Iterator<String> iterator = strset.iterator();
        iterator.next();
        String child = iterator.next();
        webDriver.switchTo().window(child);
    }
    
    public void switchWindowToParent() {
        Set<String> strset = webDriver.getWindowHandles();
        Iterator<String> iterator = strset.iterator();
        String parent = iterator.next();
        webDriver.switchTo().window(parent);
    }
    
}
