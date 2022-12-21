package com.csjfwk.wknd.utils;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

    public WebDriver webDriver = null;
    public WebDriverManager wedDriverManager;

    public WebDriver WebDriverManager() {
        System.out.println("***/!\\*** 2. in WebDriverManager() method (from TestContextSetup)");
        System.out.println("***/!\\***    we instanciate the webDriver that is gonna be used everywhere");
        Properties prop = FileUtils.getGlobalProperties();
        String url = prop.getProperty("url-test");
        String browser = prop.getProperty("browser");
        String headless = prop.getProperty("headless");
        String browserMode = (headless.equalsIgnoreCase("true")) ? "headless" : "--start-minimized";

        if (webDriver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                wedDriverManager = loadChrome(browserMode);
                webDriver = wedDriverManager.create();
            } else {
                System.err.println("browser not supported");
                System.exit(1);
            }
            webDriver.get(url);
        }
        return webDriver;
    }

    private WebDriverManager loadChrome(String browserMode) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(browserMode);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--windows-size=1920,1080");
        return WebDriverManager.chromedriver().capabilities(options);
    } 
    
}
