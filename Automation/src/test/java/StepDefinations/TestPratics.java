package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPratics {

	public static void main(String args[]) throws MalformedURLException, IOException, Throwable {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://app.endtest.io/guides/docs/how-to-test-dropdowns/");

		// print all options from dropdown
		List<WebElement> we = null;
		String str = "";

		WebElement dropdown = driver.findElement(By.id("countries"));

		Select sc = new Select(dropdown);
		we = sc.getOptions();

		for (int i = 0; i <= we.size() - 1; i++) {
			str = we.get(i).getText().trim();
			System.out.println(str);
		}

		// Webdiver Wait

		Actions as = new Actions(driver);
		as.moveToElement(dropdown).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait we1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		we1.until(ExpectedConditions.alertIsPresent());

		// FluentWait
		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver);
		fw.withTimeout(Duration.ofSeconds(10));
		fw.pollingEvery(Duration.ofSeconds(1));
		fw.ignoring(NoSuchElementException.class);

		// Get WindowHandels
		Set<String> handel = driver.getWindowHandles(); // it will always store in Set<String>
		for (String frame : handel) {
			if (driver.getTitle().contains("Goolge")) {
				driver.switchTo().window(frame);
				break;
			}
		}
		// Scroll Down
		WebElement element = driver.findElement(By.id("Input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", element);

		// Https Certificate Issue

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");

		WebDriver driver1 = new ChromeDriver(options);

		// Https Connection Check

		HttpURLConnection connection = (HttpURLConnection) new URL(
				"https://app.endtest.io/guides/docs/how-to-test-dropdowns/").openConnection();

		int resp = connection.getResponseCode();

		System.out.println(resp);

		// Screenshots

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destionation = new File("target/screenshots/" + ".png");

		try {
			FileUtils.copyFile(source, destionation);
		} catch (IOException e) {
			e.printStackTrace();

		}

		WebElement element2 = driver.findElement(By.xpath("xpath"));
		WebElement ele = driver.findElement(RelativeLocator.with(By.tagName("input")).above(element2));
		ele.getText();

		driver.close();

	}

}
