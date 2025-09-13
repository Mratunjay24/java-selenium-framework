package Utils;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) return;
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(testName + "_screenshot", new ByteArrayInputStream(screenshot));
    }
}


