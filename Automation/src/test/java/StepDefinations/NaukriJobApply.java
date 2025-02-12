package StepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import PageObject.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NaukriJobApply extends BaseClass {
	ConfigReader configReader = new ConfigReader();
	String url = configReader.getProperty("url").toLowerCase();

	@Before
	private void setUpDriver() {
		getDriver();

	}

	@Given("User Login to Naukri Application")
	public void user_login_to_naukri_application() {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Then("User provide the {string} and {string}")
	public void user_provide_the_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.id("login_Layer")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[2]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/form/div[3]/input")).sendKeys(password);

	}

	@Then("Click on the Recommended jobs")
	public void click_on_the_recommended_jobs() {
		driver.findElement(By.xpath("//div[contains(text(), 'Jobs')]")).click();
		throw new PendingException();
		

	}

	@Then("Select mutiple jobs and click on Apply")
	public void select_mutiple_jobs_and_click_on_apply() {

	}

	@After
	public void teardown(io.cucumber.java.Scenario scenario) {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String screenshotname = scenario.getName();
			File destionation = new File("target/screenshots/" + screenshotname + ".png");

			try {
				FileUtils.copyFile(source, destionation);
			} catch (IOException e) {
				e.printStackTrace();

			}

		}
		quitDriver();
	}

}
