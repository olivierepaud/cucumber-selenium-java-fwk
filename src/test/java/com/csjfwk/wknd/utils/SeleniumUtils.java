package com.csjfwk.wknd.utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtils {

    private static WebDriver webDriver = WebDriverSetup.webDriver;

    //not convinced this method below is gonna be really useful
    //it doesn't throw any exception and it returns a WebElement, possibly null, whatever happens
    public static WebElement find(By xpath) {
        String methodeName = "find()";
        WebElement webEl = null;
        try {
            webEl = webDriver.findElement(xpath);
        } catch (NoSuchElementException nsee) {
            System.out.println("***/!\\*** NoSuchElementException in "+methodeName);
            nsee.printStackTrace();
        }
        return webEl;
    }

    //same than above for multiples elements
    public static List<WebElement> findElements(By xpath) {
        String methodeName = "findElements()";
        List<WebElement> webElements = null;
        try {
            webElements = webDriver.findElements(xpath);
        } catch (NoSuchElementException nsee) {
            System.out.println("***/!\\*** NoSuchElementException in "+methodeName);
            nsee.printStackTrace();
        }
        return webElements;
    }

    public static void highLightElement(WebElement webElement) {
        String methodeName = "highLightElement()";
        try {
            String highlight = "arguments[0].setAttribute('style', 'background: #00ff00; border: 2px solid black;');";
            waitforElementToBeVisible(webElement);
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript(highlight, webElement);
            // add a quick pause after each highlight
            try {Thread.sleep(200);} catch (Exception e) {}
        } catch (Exception e) {
            System.out.println("***/!\\*** Exception in " + methodeName);
            e.printStackTrace();
        }
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

    //wait for element to be clickable, using FluentWait() class
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

    //wait for element to be clickable, using WebDriverWait() class
    public static void waitforElementTobeClickable2(WebElement element) {
        String methodeName = "waitforElementTobeClickable2()";
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println("***/!\\*** Exception in "+methodeName);
            e.printStackTrace();
        }
    }

    public static void waitHighlightAndClick(WebElement webEl) {
        String methodeName = "waitHighlightAndClick()";
        waitforElementTobeClickable(webEl);
        highLightElement(webEl);
        webEl.click();
    }

    //scroll down to a certain WebElement
    public static void scrollDownToElement(WebElement webElement) {
        String methodeName = "scrollDownToElement()";
        try {
            JavascriptExecutor jse = (JavascriptExecutor)webDriver;
            String script = "arguments[0].scrollIntoView(true);";
            jse.executeScript(script,webElement);
            //might need some adjustment on the number of pixels here
            scrollDownByBlocks(1,300);
            highLightElement(webElement);
            //webElement.click();
        } catch (Exception e) {
            System.out.println("***/!\\*** Exception in "+methodeName);            
            e.printStackTrace();
        }
    }
    
    //scrolling down by a certain number of blocks 
    //usually block_lenght_in_pixels value would be 200 or 300.
    public static void scrollDownByBlocks(int nbr_blocks, int block_lenght_in_pixels) {
        String methodeName = "scrollDownByBlocks()";
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        String script = "window.scrollBy(0," + block_lenght_in_pixels + ")";
        for (int i = 0; i < nbr_blocks; i++) {
            jse.executeScript(script);
        }
    }

    public static void scrollDownByPixels(int nbr_pixels) {
        String methodeName = "scrollDownByPixels()";
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        String script = "window.scrollBy(0," + nbr_pixels + ")";
        jse.executeScript(script);
    }

    //empty the given WebElement (should be input) and enter the given text
    public static void emptyFieldAndEnterText(WebElement webEl, String text) {
        String methodeName = "emptyFieldAndEnterText()";
        waitforElementTobeClickable(webEl);
        scrollDownToElement(webEl);
        webEl.clear();
        webEl.sendKeys(text);
        highLightElement(webEl);
    }
    
    //empty the given WebElement (should be input) and enter the given text plus the given tab
    public static void emptyFieldAndEnterText(WebElement webEl, String text, Keys key) {
        emptyFieldAndEnterText(webEl, text);
        webEl.sendKeys(key);
    }

}
