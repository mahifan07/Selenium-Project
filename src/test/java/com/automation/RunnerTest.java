package com.automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;*/


/*@RunWith(Cucumber.class)*/
@CucumberOptions(features = "src/test/resources/features", glue = "com.stepDefinitions",plugin = {
        "pretty",                              // Console output (optional)
        "html:target/cucumber-reports/index.html", // HTML report generation
        "json:target/cucumber-reports/cucumber.json", // JSON report (optional, useful for CI tools)
        "junit:target/cucumber-reports/cucumber.xml" // JUnit report (optional, useful for CI tools)
    },
    monochrome = true  // Makes the console output more readable
    )
public class RunnerTest extends AbstractTestNGCucumberTests {
}