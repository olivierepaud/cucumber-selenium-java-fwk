package com.csjfwk.wknd.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class SeleniumUtils {

    private static WebDriver webDriver = WebDriverSetup.webDriver;
    
    public static void highLightElement(WebElement webElement) {
        String highlight = "arguments[0].setAttribute('style', 'background: #00ff00; border: 3px solid black;');";
        waitforElementToBeVisible(webElement);
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript(highlight, webElement);
        // add a quick pause after each highlight
        try {Thread.sleep(500);} catch (Exception e) {}
    }

    //utilisation de la classe FluentWait
    //https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html
    public static void waitforElementToBeVisible(WebElement webElement) {
        String methodeName = "waitforElementToBeVisible()";
        try {
            FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(webDriver);
            fwait.pollingEvery(Duration.ofMillis(150));
            fwait.withTimeout(Duration.ofSeconds(8));
            fwait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("***/!\\*** Exception in "+methodeName);
            e.printStackTrace();
        }
    }

    public static void waitforElementTobeClickable(WebElement element) {
        String methodeName = "waitforElementTobeClickable()";
        try {
            FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(webDriver);
            fwait.pollingEvery(Duration.ofMillis(150));
            fwait.withTimeout(Duration.ofSeconds(8));
            fwait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("***/!\\*** Exception in "+methodeName);
            e.printStackTrace();
        }
    }
}
