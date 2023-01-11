package com.csjfwk.wknd.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;;

@RunWith(Cucumber.class)

@CucumberOptions(
    plugin = { "pretty", //applies color to cucmumber report
               "html:target/cucumber-reports/index.html", //generate HTML report
               "json:target/cucumber-reports/cucumber.json" // generate JSON report
               //"com.aventstack.extentreports.cucumber.adapter.ExtenCucumberAdapter:" //generates Extent Reports
    },
    features = {"classpath:features"},
    glue = {"com.csjfwk.wknd.bdd.stepDefinitions"},
    //tags = {"@test"}
    tags = "@theglobeandmail"
    //tags = "@runthis"
    )

public class RunCucumberTest {
    
}
