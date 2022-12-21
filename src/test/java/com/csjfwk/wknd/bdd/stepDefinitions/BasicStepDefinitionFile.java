package com.csjfwk.wknd.bdd.stepDefinitions;

import com.csjfwk.wknd.pageObjects.WebSiteHomepagePageObject;
import com.csjfwk.wknd.utils.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicStepDefinitionFile {

    private TestContextSetup contextSetup;
    private WebSiteHomepagePageObject homepagePO;

    // doesn't compile if there is no constructor with zero argument
    // which one is used?
    // public BasicStepDefinitionFile() {
    //    System.out.println("***/!\\*** in BasicStepDefinitionFile() constructor with zero argument");
    // }

    public BasicStepDefinitionFile(TestContextSetup contextSetup) {
        System.out.println("***/!\\*** 5. in BasicStepDefinitionFile(TestContextSetup) constructor (auto call)");
        System.out.println("***/!\\***    we instanciate the TestContextSetup and the page objects in the class");
        this.contextSetup = contextSetup;
        this.homepagePO = contextSetup.pageObjectsManager.getHomePagePO();
    }


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
}
