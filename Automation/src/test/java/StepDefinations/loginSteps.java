package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObject.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps extends BaseClass {

	// key value mapping
	ConfigReader configReader = new ConfigReader();
	String url = configReader.getProperty("url").toLowerCase();

	@Before
	public void setup() throws Throwable {
		getDriver();

	}

	@Given("^User login to the CRM page$")
	public void user_is_already_login_page() {
		driver.get(url);
	}

	@When("^Title of login page is Login CRM$")
	public void verify_page_titie() {

		String title = driver.getTitle();
		String actualTitle = "#1 Free CRM Software Power Up your Entire Business Free Forever";
		Assert.assertEquals(actualTitle, title);

	}

	@Then("^User enter username and User enter password$")
	public void user_enter_username_and_user_enrer_password(DataTable credentails) {
		for (Map<String, String> data : credentails.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")).click();
			driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input"))
					.sendKeys(data.get("username"));
			driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input"))
					.sendKeys(data.get("password"));
		}
	}

	@Then("User enter username \"(.*)\" and User enter password \"(.*)\"$")
	public void user_enter_username_and_user_enrer_password(String string, String string2) {
		driver.findElement(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")).sendKeys(string2);

	}

	@Then("^User click on Login button$")
	public void user_click_login() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();

	}

	@Then("^User is on Homepage$")
	public void user_on_homepage() throws Throwable {
		String homepagetitile = driver.getTitle();
		Assert.assertEquals("Cogmento CRM", homepagetitile);
		Thread.sleep(2000);

	}

	@Then("^User click on Add Contact and enter \"(.*)\" and \"(.*)\"$")
	public void user_click_on_add_contact_and_enter_and(String string, String string2) throws Throwable {
		WebElement hoverable = driver.findElement(By.xpath("//span[text()='Contacts']/parent::a"));
		new Actions(driver).moveToElement(hoverable).click().perform();
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.name("first_name")).sendKeys(string);
		driver.findElement(By.name("last_name")).sendKeys(string);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
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
