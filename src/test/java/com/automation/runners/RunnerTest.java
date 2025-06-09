package com.automation.runners;

import org.junit.Before;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",         // Path to your .feature files
    glue = {
        "com.automation.stepdefinitions",             // Step Definitions
        "com.automation.hooks"                        // Hooks like ScreenshotHooks
    },
    plugin = {
        "pretty",                                     // For readable console output
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure report integration
    },
    monochrome = true,                                 // Cleaner output
    dryRun = false                                   // Set to true to check for missing step definitions without running tests
)
//This class serves as the entry point for running Cucumber tests with JUnit.
public class RunnerTest {
    // No additional code needed. JUnit will handle execution.
	@Before
	public void run() {
		System.out.println("Running Cucumber tests...");
	}
}
