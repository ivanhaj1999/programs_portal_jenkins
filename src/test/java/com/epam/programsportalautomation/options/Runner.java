package com.epam.programsportalautomation.options;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"html:target/cucumber-reports/report.html"},
        glue = {"stepdefs"},
        features = {"src/test/resources/programs_portal_features/open_add_college_page.feature"},
        monochrome = true,
        publish = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
//com.cucumber.listener.ExtentCucumberFormatter