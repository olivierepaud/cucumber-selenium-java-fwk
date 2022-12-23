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
    
    private WebDriver webDriver;
    private Properties properties;
    private WebDriverWait wait;

    //xpath of the site title "The Globe and Mail"
    private By site_title_xpath = By.xpath("//div[@class='c-site-header__logo c-site-header__logo--wide']//a[@aria-label='The Globe and Mail']");
    //xpath of the Register button
    private By register_button_xpath = By.xpath("//span[normalize-space()='Register']");
    //xpath of the search button
    private By search_button_xpath = By.xpath("//button[@aria-label='Open search panel']");
    //xpath of the input field for email
    private By input_email_xpath = By.xpath("//input[@id='email']");
    //xpath of the input field for password
    private By input_password_xpath = By.xpath("//input[@id='password']");
    //xpath of the input field for postal code
    private By input_postalcode_xpath = By.xpath("//input[@id='postalcode']");
    //xpath of the Create My Free Account button
    private By create_account_button_xpath = By.xpath("//button[@aria-label='Create My Free Account']");
    //xpath of the cross to close the register pop-up
    private By close_register_popup_xpath = By.xpath("//button[@id='register-modal-close']");


    public WebSiteHomepagePageObject(WebDriver driver) {
        System.out.println("***/!\\*** 6. in WebSiteHomepagePageObject(WebDriver) constructor (from step def file)");
        System.out.println("***/!\\***    we instanciate the webDriver in the class");
        this.webDriver = driver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        properties = FileUtils.getGlobalProperties();
    }

    public void verifyHomePageTitle() throws InterruptedException {
        String methodeName = "verifyHomePageTitle()";
        try {
            WebElement webElement = webDriver.findElement(site_title_xpath);
            String actualTitle = webElement.getText();
            String expectedSiteTitle = properties.getProperty("site-title");    
            Assert.assertEquals(expectedSiteTitle, actualTitle);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in "+methodeName);
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void verifyRegisterButton() throws InterruptedException {
        String methodeName = "verifyRegisterButton()";
        try {
            WebElement webElement = webDriver.findElement(register_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifyRegisterButton()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void clickOnRegisterButton() throws InterruptedException {
        String methodeName = "clickOnRegisterButton()";
        try {
            WebElement webElement = webDriver.findElement(register_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in clickOnRegisterButton()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void verifySearchButton() throws InterruptedException {
        String methodeName = "verifySearchButton()";
        try {
            WebElement webElement = webDriver.findElement(search_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifySearchButton()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void fillTheRegistrationForm() throws InterruptedException {
        String methodeName = "fillTheRegistrationForm()";
        try {
            //System.out.println("***/!\\*** fillTheRegistrationForm() MARQUEUR 1");
            Thread.sleep(2000);
            String email = properties.getProperty("email");
            String password = properties.getProperty("password");
            String postalCode = properties.getProperty("postal-code");
            webDriver.findElement(input_email_xpath).sendKeys(email);
            webDriver.findElement(input_password_xpath).sendKeys(password);
            webDriver.findElement(input_postalcode_xpath).sendKeys(postalCode);
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in fillTheRegistrationForm()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    public void verifyCreateAccountButton() throws InterruptedException {
        String methodeName = "verifyCreateAccountButton()";
        try {
            WebElement webElement = webDriver.findElement(create_account_button_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in verifyCreateAccountButton()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
    
    public void closeRegisterPopup() throws InterruptedException {
        String methodeName = "closeRegisterPopup()";
        try {
            WebElement webElement = webDriver.findElement(close_register_popup_xpath);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            System.out.println("***/!\\*** ALL GOOD in "+methodeName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e) {
            System.out.println("***/!\\*** Exception in closeRegisterPopup()");
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }



/*
    private void waitElementToClick(WebElement element) {
        try {
            FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(webDriver);
            fwait.pollingEvery(Duration.ofMillis(150));
            fwait.withTimeout(Duration.ofSeconds(8));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("***\/!\\*** waitElementToClick(): unable to find Element");
            e.printStackTrace();
        }
    }
    */
}
