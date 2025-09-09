package org.base;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    // ThreadLocal for parallel execution safety
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Set driver instance for current thread
    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    // Get driver instance for current thread
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // Quit and remove driver for current thread
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove(); // Prevent memory leaks
        }
    }
}
