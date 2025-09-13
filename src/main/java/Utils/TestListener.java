package Utils;
import org.base.DriverManager;
import org.testng.ITestResult;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

        @Override
        public void onTestFailure(ITestResult result) {
            WebDriver driver = DriverManager.getDriver(); // adjust to your base class
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }

        @Override
        public void onStart(ITestContext context) {}
        @Override
        public void onFinish(ITestContext context) {}
        @Override
        public void onTestSuccess(ITestResult result) {}
    }


