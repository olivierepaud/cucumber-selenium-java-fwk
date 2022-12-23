package com.csjfwk.wknd.utils;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSetup {

    public static WebDriver webDriver = null;
    public WebDriverManager webDriverManager;

    public WebDriver WebDriverManager() {
        System.out.println("***/!\\*** 2. in WebDriverManager() method (from TestContextSetup)");
        System.out.println("***/!\\***    we instanciate the webDriver that is gonna be used everywhere");
        Properties prop = FileUtils.getGlobalProperties();
        String url = prop.getProperty("url-test");
        String browser = prop.getProperty("browser");
        String headless = prop.getProperty("headless");
        String browserMode = (headless.equalsIgnoreCase("true")) ? "headless" : "--start-minimized";
        // on force le fullscreen à l'arrache
        // browserMode = "--start-fullscreen";
        // on force le maximized à l'arrache (mieux que le full-screen)
        browserMode = "--start-maximized";
        System.out.println("***/!\\*** forcing the browser mode to: "+browserMode);

        if (webDriver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                webDriverManager = loadChrome(browserMode);
                webDriver = webDriverManager.create();
            } else {
                System.err.println("browser not supported");
                System.exit(1);
            }
            webDriver.get(url);
        }
        // pour forcer la dimension de la fenêtre de Chrome: (si l'option windows-size ne fonctionne pas)
        //webDriver.manage().window().setSize(new Dimension(1920,1080));
        //webDriver.manage().window().setSize(new Dimension(1600,900));
        //webDriver.manage().window().setSize(new Dimension(1536,864));
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
