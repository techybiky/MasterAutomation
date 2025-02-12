package StepDefinations;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class dealsStep {

	WebDriver driver;

	
// DataTable mapping
//	@Then("^User move to deal page and create a new deals$")
//	public void user_click_on_add_contact_and_enter_and(DataTable creidentails) throws Throwable {
//		List<List<String>> data = creidentails.asLists();
//		WebElement hoverable = driver.findElement(By.xpath("//span[text()='Deals']/parent::a"));
//		new Actions(driver).moveToElement(hoverable).click().perform();
//		driver.findElement(By.xpath("//button[text()='Create']")).click();
//		driver.findElement(By.name("title")).sendKeys(data.get(0).get(0));
//		driver.findElement(By.name("probability")).sendKeys(data.get(0).get(1));
//		driver.findElement(By.name("amount")).sendKeys(data.get(0).get(2));
//		driver.findElement(By.name("commission")).sendKeys(data.get(0).get(3));
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		Thread.sleep(2000);
//	}

// key value mapping
	@Then("^User move to deal page and create a new deals$")
	public void user_click_on_add_contact_and_enter_and(DataTable creidentails) throws Throwable {
		for (Map<String, String> data : creidentails.asMaps(String.class, String.class)) {
			WebElement hoverable = driver.findElement(By.xpath("//span[text()='Deals']/parent::a"));
			new Actions(driver).moveToElement(hoverable).click().perform();
			driver.findElement(By.xpath("//button[text()='Create']")).click();
			driver.findElement(By.name("title")).sendKeys(data.get("title"));
			driver.findElement(By.name("probability")).sendKeys(data.get("probability"));
			driver.findElement(By.name("amount")).sendKeys(data.get("amount"));
			driver.findElement(By.name("commission")).sendKeys(data.get("commission"));
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			Thread.sleep(2000);
			
			WebDriverWait we = new WebDriverWait(driver,Duration.ofSeconds(1000));
			we.until(ExpectedConditions.alertIsPresent());
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			
		}
	}
	

}
