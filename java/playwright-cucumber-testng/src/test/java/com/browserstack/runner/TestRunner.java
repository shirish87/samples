package com.browserstack.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.browserstack.steps",
    plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
