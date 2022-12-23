package com.csjfwk.wknd.bdd.stepDefinitions;

import com.csjfwk.wknd.pageObjects.TheGlobeAndMailHomepagePageObject;
import com.csjfwk.wknd.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TheGlobeAndMailDefinitionFile {

    private TestContextSetup testContextSetup;
    private TheGlobeAndMailHomepagePageObject homepagePO;

    // doesn't compile if there is no constructor with zero argument
    // which one is used?
    // public BasicStepDefinitionFile() {
    //    System.out.println("***/!\\*** in BasicStepDefinitionFile() constructor with zero argument");
    // }

    public TheGlobeAndMailDefinitionFile(TestContextSetup contextSetup) {
        System.out.println("***/!\\*** 5. in BasicStepDefinitionFile(TestContextSetup) constructor (auto call)");
        System.out.println("***/!\\***    we instanciate the TestContextSetup and the page objects in the class");
        this.testContextSetup = contextSetup;
        this.homepagePO = contextSetup.pageObjectsManager.getHomePagePO();
    }


    // TEST SCENARIO
    // Scenario: End-User can successfully access The Globe And Mail homepage and its content
    // first test added. basic test to open Chrome, navigate to a url and verify a few things in the page.

    @Given("that I am an end-user that wants to get fresh news on The Globe And Mail website")
    public void that_i_am_an_end_user_that_wants_to_get_fresh_news_on_the_globe_and_mail_website() {
        // nothing to do here
    }

    @When("I navigate to The Globe And Mail website")
    public void i_navigate_to_the_globe_and_mail_website() {
        // nothing to do here
    }

    @Then("I am able to verify that the homepage is correctly loaded in my browser")
    public void i_am_able_to_verify_that_the_homepage_is_correctly_loaded_in_my_browser() {
        // nothing to do here
    }
    
    @Then("that the title of the homepage is The Globe And Mail")
    public void that_the_title_of_the_homepage_is_the_globe_and_mail() throws InterruptedException {
        homepagePO.verifyHomePageTitle();
    }

    @Then("that there is a button to register that is clickable")
    public void that_there_is_a_button_to_register_that_is_clickable() throws InterruptedException {
        homepagePO.verifyRegisterButton();
    }

    @Then("that there is also a Search button that is clickable")
    public void that_there_is_also_a_search_button_that_is_clickable() throws InterruptedException {
        homepagePO.verifySearchButton();
    }


    // TEST SCENARIO
    // Scenario: End-User can successfully starts the registration process on The Globe And Mail homepage and then cancel it
    // second test added. 
    // this test introduces the basic use on input fields as well as the change of iframe focus.

    @Given("that I am an end-user that wants to register on The Globe And Mail website")
    public void that_i_am_an_end_user_that_wants_to_register_on_the_globe_and_mail_website() {
        // nothing to do here
    }

    @When("I navigate to The Globe And Mail website homepage")
    public void i_navigate_to_the_globe_and_mail_website_homepage() {
        // nothing to do here
    }

    //step already implemented above
    //@Then("I am able to verify that the homepage is correctly loaded in my browser")
    //public void i_am_able_to_verify_that_the_homepage_is_correctly_loaded_in_my_browser() {}

    @Then("I am able to click on the Register button to open the register pop-up")
    public void i_am_able_to_click_on_the_register_button_to_open_the_register_pop_up() throws InterruptedException {
        homepagePO.clickOnRegisterButton();
        //wait for the pop-up to open
        Thread.sleep(2000);
        //switch to the iframe that corresponds to the register pop-up to fill it in
        //source: https://www.tutorialspoint.com/how-to-switch-back-from-a-frame-to-default-in-selenium-webdriver
        testContextSetup.webDriver.switchTo().frame("register-modal-iframe");
    }

    @When("I enter my email address and password and postal code")
    public void i_enter_my_email_address_and_password_and_postal_code() throws InterruptedException {
        homepagePO.fillTheRegistrationForm();
    }

    @Then("I can verify that my information entered is properly displayed in the form")
    public void i_can_verify_that_my_information_entered_is_properly_displayed_in_the_form() {
        // nothing to do here
    }

    @Then("that the CREATE MY FREE ACCOUNT button is clickable")
    public void that_the_create_my_free_account_button_is_clickable() throws InterruptedException {
        homepagePO.verifyCreateAccountButton();
        //switch back to the main iframe to be able to close the register pop-up
        //source: https://www.tutorialspoint.com/how-to-switch-back-from-a-frame-to-default-in-selenium-webdriver
        testContextSetup.webDriver.switchTo().defaultContent();
    }

    @When("I click on the cross to close the register pop-up")
    public void i_click_on_the_cross_to_close_the_register_pop_up() throws InterruptedException {
        homepagePO.closeRegisterPopup();
    }

    @Then("I can verify that the register pop-up is closed")
    public void i_can_verify_that_the_register_pop_up_is_closed() {
        // nothing to do here
    }

    @Then("that I am back to the website homepage")
    public void that_i_am_back_to_the_website_homepage() throws InterruptedException {
        homepagePO.verifyHomePageTitle();
    }

}