package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {

    private FileInputStream file;
    private Properties property = new Properties();

    public Properties getProperties () {
        try {
            file = new FileInputStream("C:\\Users\\kkami\\IdeaProjects\\Cars\\src\\main\\resources\\properties\\config.properties");
            property.load(file);
        } catch (IOException e) {
            System.out.println("Not found");
        }
        return property;
    }
}