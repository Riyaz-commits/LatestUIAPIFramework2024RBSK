package reader;

import utils.helpers.FileUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {
    public static Properties prop = null;

    public ConfigPropertyReader() {
    }

    public final String PropertyFilePath = System.getProperty("user.dir")+"/src/main/resources/properties/";

    public void loadProperties() {
        try {
            prop = new Properties();
            FileUtil fileUtil = new FileUtil();
            for (String file : fileUtil.getFileUnderDirectory(PropertyFilePath)) {
                FileInputStream ip = new FileInputStream(PropertyFilePath + file);
                prop.load(ip);
                for (String name : prop.stringPropertyNames()) {
                    String value = prop.getProperty(name);
                    System.setProperty(name, value);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
