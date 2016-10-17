package ru.itis.inform.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {

    private InputStream fis;
    private Properties property = new Properties();

    public Properties getProperties () {
        try {
            fis = getClass().getResourceAsStream("/properties/config.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return property;
        }
    }
}