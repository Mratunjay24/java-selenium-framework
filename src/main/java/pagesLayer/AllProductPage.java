package pagesLayer;

import Utils.TestLocatorsReader;
import org.base.PredefinedActions;
import org.openqa.selenium.WebDriver;

public class AllProductPage extends PredefinedActions {
    String allProductsTitle = TestLocatorsReader.get("allProductsTitle");
    String firstProductID = TestLocatorsReader.get("firstProductID");;
    String firstProductName= TestLocatorsReader.get("firstProductName");;

    private WebDriver driver;

    public AllProductPage(WebDriver driver) {
        this.driver = driver;
    }



    // Page Actions
    public String getPageTitle(WebDriver driver)
    {
        return PredefinedActions.getElement(driver,"xpath",allProductsTitle,false).getText();

    }
    public String getTheText() {
        return driver.findElement(org.openqa.selenium.By.xpath(firstProductName)).getText();

    }
}