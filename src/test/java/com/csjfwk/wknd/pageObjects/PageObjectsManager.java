package com.csjfwk.wknd.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {

    public WebDriver webDriver;
    public TheGlobeAndMailHomepagePageObject homepagePO;

    public PageObjectsManager(WebDriver driver) {
        System.out.println("***/!\\*** 4. in PageObjectsManager(WebDriver) constructor (from TestContextSetup)");
        System.out.println("***/!\\***    we instanciate the webDriver in the class");
        webDriver = driver;
    }

    // TODO : pourquoi ne pas tester d'abord la valeur à null du paramètre ?
    // plutôt que de faire un new a chaque appel de cette méthode, ne peut-on pas utiliser toujours la même instance ?
    public TheGlobeAndMailHomepagePageObject getHomePagePO() {
        homepagePO = new TheGlobeAndMailHomepagePageObject(webDriver);
        return homepagePO;
    }
}
