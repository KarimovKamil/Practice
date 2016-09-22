package ru.itis.inform.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {

    private InputStream file;
    private Properties property = new Properties();

    public Properties getProperties () {
        try {
            file = getClass().getResourceAsStream("/properties/config.properties");
            property.load(file);
        } catch (IOException e) {
            System.out.println("Not found");
        }
        return property;
    }
}