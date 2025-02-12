package StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCheckBoxBasedOnString {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		
		for(WebElement row:rows) {
			
			if(row.getText().contains("Euro")) {
				
				WebElement checkbox= row.findElement(By.xpath(".//input[@type='checkbox']"));
				
				if(!checkbox.isSelected()) {
					checkbox.click();
					System.out.println("Check Box is Selected with Value Euro");
				}
			}
		}
		driver.close();
	}
}
