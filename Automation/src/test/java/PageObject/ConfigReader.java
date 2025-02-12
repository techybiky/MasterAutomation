package PageObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("⚠ ERROR: config.properties file NOT found in resources folder! Check if the file exists in src/main/resources.");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("⚠ ERROR: Failed to load config.properties file!", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "⚠ Key Not Found!");
    }
}
