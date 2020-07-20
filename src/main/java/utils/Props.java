package utils;

import java.io.IOException;
import java.util.Properties;

public class Props {
    public static final String SETTINGS = "/application.properties";
    private final static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(utils.Props.class.getResourceAsStream(SETTINGS));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return PROPERTIES.getProperty(key);
    }
}