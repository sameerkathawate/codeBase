package commonLibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

    Properties config;
    public ConfigUtils() throws IOException {
        config = new Properties();
        FileInputStream input = new FileInputStream("config/config.properties");
        config.load(input);
        input.close();
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
