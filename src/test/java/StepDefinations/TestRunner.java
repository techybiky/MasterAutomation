package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
features="src/test/resources/Feature/login.feature", 
glue= {"StepDefinations"},
tags = "@instance_1",
plugin = {"pretty", "html:bin/cucumber-junit/htmloutput","junit:bin/cucumber-junit/Webpage.xml","html:target/cucumber-reports"},
dryRun = false, //check whether all the steps from feature files has got methods and implemented or no in Step Definition File
monochrome = true
) 

public class TestRunner {

}
