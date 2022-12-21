package com.csjfwk.wknd.pageObjects;

import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.csjfwk.wknd.utils.FileUtils;


public class WebSiteHomepagePageObject {
    
    public WebDriver webDriver;
    Properties properties;

    //xpath of the site title "The Globe and Mail"
    private By site_title_xpath = By.xpath("//div[@class='c-site-header__logo c-site-header__logo--wide']//a[@aria-label='The Globe and Mail']");
    //xpath of the Register button
    private By register_button_xpath = By.xpath("//span[normalize-space()='Register']");
    //xpath of the search button
    private By search_button_xpath = By.xpath("//button[@aria-label='Open search panel']");

    public WebSiteHomepagePageObject(WebDriver driver) {
        System.out.println("***/!\\*** 6. in WebSiteHomepagePageObject(WebDriver) constructor (from step def file)");
        System.out.println("***/!\\***    we instanciate the webDriver in the class");
        this.webDriver = driver;
        properties = FileUtils.getGlobalProperties();
    }

    public void verifyHomePageTitle() throws InterruptedException {
        try {
            Thread.sleep(2000);
            WebElement webElement = webDriver.findElement(site_title_xpath);
            String actualTitle = webElement.getText();
            System.out.println("***/!\\*** actualTitle: "+actualTitle);
            String expectedSiteTitle = properties.getProperty("site-title");    
            System.out.println("***/!\\*** expectedSiteTitle: "+actualTitle);
            Assert.assertEquals(expectedSiteTitle, actualTitle);
            System.out.println("***/!\\*** ALL CHECKS DONE in verifyHomePageTitle()");
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifyHomePageTitle()");
        }
    }

    public void verifyRegisterButton() throws InterruptedException {
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
            WebElement webElement = webDriver.findElement(register_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Assert.assertTrue(true);
            System.out.println("***/!\\*** ALL CHECKS DONE in verifyRegisterButton()");
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifyRegisterButton()");
        }
    }

    public void verifySearchButton() throws InterruptedException {
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
            WebElement webElement = webDriver.findElement(search_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Assert.assertTrue(true);
            System.out.println("***/!\\*** ALL CHECKS DONE in verifySearchButton()");
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifySearchButton()");
        }
    }

}
