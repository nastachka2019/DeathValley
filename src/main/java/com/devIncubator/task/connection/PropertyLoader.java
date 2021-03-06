package com.devIncubator.task.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class for download of properties
 *
 * @author Shpakova A.
 */

class PropertyLoader {

    private static final Logger logger = LogManager.getLogger();

    /**
     * Method:download and read resources
     */

    Properties setProperty(String fileName) {
        Properties properties = new Properties();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName); //resource loading(reading)
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            logger.fatal("Error loadFile", e);
        }
        return properties;
    }
}
