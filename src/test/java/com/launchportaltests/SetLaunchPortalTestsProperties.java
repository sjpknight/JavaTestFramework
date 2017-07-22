package com.launchportaltests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class SetLaunchPortalTestsProperties {

    //public static void main(String[] args) {
    public void initialiseTestProperties() {

        Properties properties = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("LaunchPortalTests.properties");

            // set the properties values
            properties.setProperty("localUrl", "http://localhost:8080/launch41SB/");
            properties.setProperty("adminUserName", "administrator");
            properties.setProperty("adminUserPassword", "QWdF94");

            //save the properties to root folder
            properties.store(output, null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void initialiseLog4jProperties() {
        Properties properties = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("log4j.properties");

            // set the properties values
            // todo setup properties for desired level of logging rather than current, somewhat excessivel level
            properties.setProperty("log4j.rootLogger", "DEBUG, Appender1, Appender2");
            properties.setProperty("log4j.appender.Appender1", "org.apache.log4j.ConsoleAppender");
            properties.setProperty("log4j.appender.Appender1.layout", "org.apache.log4j.PatternLayout");
            properties.setProperty("log4j.appender.Appender1.layout.ConversionPattern", "%-7p %d [%t] %c %x - %m%n");
            properties.setProperty("log4j.appender.Appender2", "org.apache.log4j.FileAppender");
            properties.setProperty("log4j.appender.Appender2.File", "testlog.txt");
            properties.setProperty("log4j.appender.Appender2.layout", "org.apache.log4j.PatternLayout");
            properties.setProperty("log4j.appender.Appender2.layout.ConversionPattern", "%-7p %d [%t] %c %x - %m%n");

            //save the properties to root folder
            properties.store(output, null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map getTestProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        Map propsToReturn = new HashMap();

        try {

            // load the properties file
            input = new FileInputStream("LaunchPortalTests.properties");
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
            input = new FileInputStream("log4j.properties");
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