package org.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class DriverManager {

        private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static void initDriver(String browser) {
            if (driver.get() == null) {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver.set(new ChromeDriver());
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver.set(new FirefoxDriver());
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
                getDriver().manage().window().maximize();
            }
        }

        public static WebDriver getDriver() {
            return driver.get();
        }

        public static void quitDriver() {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        }
}
