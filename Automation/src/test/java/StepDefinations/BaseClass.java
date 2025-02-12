package StepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            Properties prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String browser = prop.getProperty("browser").toLowerCase();
            boolean isHeadless = Boolean.parseBoolean(prop.getProperty("headless"));

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeDriver = new EdgeOptions();
                    if (isHeadless) {
                    	edgeDriver.addArguments("--headless");
                    }
                    driver = new EdgeDriver(edgeDriver);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


