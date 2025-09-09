package basePackage;
import org.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import Utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.base.DriverManager;

public class BaseClass {


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Read browser from config.properties or system property
        String browser = ConfigReader.get("browser", "chrome");
        String baseUrl = ConfigReader.get("baseUrl", "https://automationexercise.com/");

        // Factory method: creates driver but does NOT manage ThreadLocal
        // Create driver and register with ThreadLocal manager
        WebDriver driver = DriverFactory.createDriver(browser);


        // Navigate to baseUrl if present
        if (!baseUrl.isEmpty()) {
            DriverFactory.getDriver().get(baseUrl);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Protected getter so child test classes can access driver
    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
