package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
features="src/test/resources/Feature/restApiTest.feature", 
glue= {"StepDefinations"},
tags = "@instance_6",
plugin = {"pretty", "html:bin/cucumber-junit/htmloutput","junit:bin/cucumber-junit/Webpage.xml","html:target/cucumber-reports"},
dryRun = false, //check whether all the steps from feature files has got methods and implemented or no in Step Definition File
monochrome = true
) 

public class TestRunner extends AbstractTestNGCucumberTests  {
	@Override	
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}

}
