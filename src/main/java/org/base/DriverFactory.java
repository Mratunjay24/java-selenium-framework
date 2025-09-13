package org.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public final class DriverFactory {

       public static WebDriver createDriver(String browser) {

            WebDriver driver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    if(System.getenv("AGENT_NAME") != null) { // Running in pipeline
                        options.addArguments("--headless");
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


