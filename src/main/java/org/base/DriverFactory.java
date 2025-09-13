package org.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public final class DriverFactory {

       public static WebDriver createDriver(String browser) {

            WebDriver driver;
           boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    if (headless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(options);

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
            return driver;
        }
    }


