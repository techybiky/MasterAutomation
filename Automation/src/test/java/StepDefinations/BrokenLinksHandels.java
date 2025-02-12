package StepDefinations;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandels {

	public static void main(String args[]) {
		// Https Connection Check
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3.org/QA/2002/04/valid-image");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getDomProperty("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is Empty: " + link.getText());
				continue;

			}
			try {
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				int response = connection.getResponseCode();
				if (response >= 400) {
					System.out.println("Broken Link : " + url + "Response" + response);

				} else {
					System.out.println("Valid Link : " + url + "Response" + response);
				}
			} catch (Exception e) {
				System.out.println("Exception of URL : "+url+"-->"+e.getMessage());

			}
		}
		driver.close();

	}
}
