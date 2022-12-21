package com.csjfwk.wknd.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {

    public WebDriver webDriver;
    public WebSiteHomepagePageObject homepagePO;

    public PageObjectsManager(WebDriver driver) {
        System.out.println("***/!\\*** 3. in PageObjectsManager(WebDriver) constructor (from TestContextSetup)");
        System.out.println("***/!\\***    we instanciate the webDriver in the class");
        webDriver = driver;
    }

    public WebSiteHomepagePageObject getHomePagePO() {
        homepagePO = new WebSiteHomepagePageObject(webDriver);
        return homepagePO;
    }
}
