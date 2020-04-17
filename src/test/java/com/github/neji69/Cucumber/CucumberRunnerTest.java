package com.github.neji69.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = {"com.github.neji69.Cucumber.stepdefs"}
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
