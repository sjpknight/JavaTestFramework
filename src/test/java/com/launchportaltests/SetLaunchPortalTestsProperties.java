package com.launchportaltests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class SetLaunchPortalTestsProperties {

    public Map getTestProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        Map propsToReturn = new HashMap();

        try {

            // load the properties file
            input = new FileInputStream("src/test/resources/LaunchPortalTests.properties");
            properties.load(input);

            // add properties to propsToReturn HashMap
            propsToReturn.put("localUrl", properties.getProperty("localUrl"));
            propsToReturn.put("adminUserName", properties.getProperty("adminUserName"));
            propsToReturn.put("adminUserPassword", properties.getProperty("adminUserPassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propsToReturn;
    }

    public Logger getLogger() {
        Properties properties = new Properties();
        InputStream input = null;

        try {

            // load the properties file
            input = new FileInputStream("src/test/resources/log4j.properties");
            properties.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PropertyConfigurator.configure(properties);
        Logger logger = Logger.getLogger("logger");
        return logger;
    }
}