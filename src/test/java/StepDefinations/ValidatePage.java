package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidatePage {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://classification.nlm.nih.gov/schedules/search");
		boolean found = false;

		while (!found) {
			List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr"));

			for (WebElement cell : row) {

				if (cell.getText().contains("System")) {
					System.out.println("✅ 'System' found! Stopping execution");
					found = true;
					break;
				}

			}
			if (found) {
				break;
			}
			List<WebElement> nextButtons = driver.findElements(By.xpath("//a[text()='Next']"));

			if (nextButtons.size() > 0) {
				nextButtons.get(0).click(); // Click on "Next" page
			} else {
				break; // No more pages, exit loop
			}
			if (!found) {
				System.out.println("❌ 'System' NOT found on any page.");
			}

			// Close the browser

		}
		driver.close();
	}

}
