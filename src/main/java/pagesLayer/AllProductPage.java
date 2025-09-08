package pagesLayer;

import org.base.DriverManager;
import org.openqa.selenium.WebDriver;

public class AllProductPage {
    String allProduct = "//h2[text()='All Products']";
    String firstProductID = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]";
    String firstProductName= "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/preceding-sibling::p[1]";

    private WebDriver driver;

    public AllProductPage() {
        this.driver = DriverManager.getDriver();
    }

    // Page Actions
    public String getPageTitle() {
        return driver.findElement(org.openqa.selenium.By.xpath(allProduct)).getText();
    }
    public String getTheText() {
        return driver.findElement(org.openqa.selenium.By.xpath(firstProductName)).getText();

    }


}