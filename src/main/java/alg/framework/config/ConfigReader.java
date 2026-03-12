package alg.framework.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();

            FileInputStream file = new FileInputStream("src/test/resources/config.properties");

            properties.load(file);
        } catch (FileNotFoundException e) {
            System.err.println("file not found in class: "+ ConfigReader.class.toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("IOException in class: "+ ConfigReader.class.toString());
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
