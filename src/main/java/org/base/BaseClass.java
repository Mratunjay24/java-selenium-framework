package org.base;

import org.openqa.selenium.WebDriver;
import Utils.ConfigReader;

public class BaseClass {


    public void setUp() {
        // read values from config.properties
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("baseUrl");

        // initialize driver
        DriverManager.initDriver(browser);

        // navigate to base URL
        DriverManager.getDriver().get(url);
    }


    public void tearDown() {
        // quit driver after each test
        DriverManager.quitDriver();
    }

    // Protected getter so child test classes can access driver
    protected WebDriver getDriver() {

        return DriverManager.getDriver();
    }
}
