package basePackage;
import org.base.DriverFactory;
import org.base.DriverManager;
import org.openqa.selenium.WebDriver;
import Utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {


    public WebDriver setUp() {
        // Read browser from config.properties or system property
        String browser = ConfigReader.get("browser", "chrome");
        String baseUrl = ConfigReader.get("baseUrl", "https://automationexercise.com/");

        // Factory method: creates driver but does NOT manage ThreadLocal
        // DriverManager set and register driver with ThreadLocal manager

        WebDriver driver = DriverFactory.createDriver(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver();
        driver.manage().window().maximize();

        // Navigate to baseUrl if present
        if (!baseUrl.isEmpty()) {
            driver.get(baseUrl);
        }
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
