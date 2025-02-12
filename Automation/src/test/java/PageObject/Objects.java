package PageObject;

import org.openqa.selenium.By;

public class Objects {

	By user_name = By.name("email");
	By pass_word = By.name("password");
	By login_button = By.className("ui fluid large blue submit button");
	By create_button = By.xpath("//button[text()='Create']");
	By first_name = By.id("first_name");
	By last_name = By.id("last_name");
	By save_button = By.xpath("//button[text()='Save']");
	
}
