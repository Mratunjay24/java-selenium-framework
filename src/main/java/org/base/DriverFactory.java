package org.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    /**
     * Thread-safe DriverFactory (ThreadLocal).
     * - Call setDriver(browser) in @BeforeMethod
     * - Call quitDriver() in @AfterMethod
     */
    public final class DriverFactory {

        private DriverFactory() {}




        public static WebDriver createDriver(String browser) {

            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            // Store in ThreadLocal for parallel safety
            DriverManager.setDriver(driver);
            DriverManager.getDriver();
            driver.manage().window().maximize();
            return driver;
        }
        // Quit driver
        public static void quitDriver() {
            WebDriver drv = DriverManager.getDriver();
            if (drv != null) {
                try {
                    drv.quit();
                } catch (Exception ignored) {}
                DriverManager.quitDriver();
            }
        }
    }


