package com.csjfwk.wknd.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)

@CucumberOptions(
    plugin = { "pretty",
               "html:target/cucumber-reports/index.html",
               "json:target/cucumber-reports/cucumber.json"
               //"com.aventstack.extentreports.cucumber.adapter.ExtenCucumberAdapter:"
    },
    features = {"classpath:features"},
    glue = {"com.csjfwk.wknd.bdd.stepDefinitions"}
    //tags = {"@test"}
)

public class RunCucumberTest {
    
}
