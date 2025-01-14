package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader(String filePath) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "Key not found: " + key);
    }

    public static void main(String[] args) {

        ConfigReader configReader = new ConfigReader("src/main/resources/messages_en.properties");
        System.out.println(configReader.getProperty("welcome"));
        System.out.println(configReader.getProperty("invalidName"));
        System.out.println(configReader.getProperty("nonexistentKey"));
    }
}