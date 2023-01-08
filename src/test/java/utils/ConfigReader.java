package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    static {
        try {
            String fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\app.properties";
            FileInputStream config = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(config);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String get(String keyName) {
        return prop.getProperty(keyName);
    }
}