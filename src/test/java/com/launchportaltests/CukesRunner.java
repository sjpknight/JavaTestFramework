package com.launchportaltests;

import java.util.Map;

import org.apache.log4j.Logger;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"}
)

public class CukesRunner {

    public static WebDriver driver;
    public static Map props;
    public static Logger logger;

    @BeforeClass
    public static void setUp() {
        SetLaunchPortalTestsProperties myTestProperties = new SetLaunchPortalTestsProperties();
        props = myTestProperties.getTestProperties();
        logger = myTestProperties.getLogger();
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
