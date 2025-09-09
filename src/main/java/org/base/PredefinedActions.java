package org.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class PredefinedActions {


    private final WebDriver driver;
    private final WebDriverWait wait;

    // Instance constructor (driver-aware actions)
    public PredefinedActions(WebDriver driver, long timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    // ==========================
    // ✅ Instance methods (need driver)
    // ==========================
    public WebElement getElement(By locator, boolean isWaitRequired) {
        return isWaitRequired
                ? wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                : driver.findElement(locator);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public List<String> getTextOfAllElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        List<String> texts = new ArrayList<>();
        for (WebElement e : elements) texts.add(e.getText());
        return texts;
    }

    // ==========================
    // ✅ Static methods (stateless helpers)
    // ==========================
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static String getJsReadyState(WebDriver driver) {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString();
    }

    public static void scrollBy(WebDriver driver, int px) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + px + ")");
    }
}
