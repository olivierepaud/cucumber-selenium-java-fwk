package com.csjfwk.wknd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * The FileUtils class contains methods to handle the configuration files.
 */
public final class FileUtils {
    
    /**
     * Returns the global properties file.
     * @return Properties the configuration file glocal.properties
     */
    public static Properties getGlobalProperties() {
        Properties prop = new Properties();
        try {
            //String name = System.getProperty("user.dir") + "src\\test\\resources\\global.properties";
            String name = "C:\\Development\\cucumber-selenium-java-fwk\\src\\test\\resources\\global.properties";
            FileInputStream fis = new FileInputStream(name);
            prop.load(fis);

        } catch (FileNotFoundException fnfe) {
            System.err.println("global.properties file not found");
            fnfe.printStackTrace();;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return prop;
    }
}
