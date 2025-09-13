package pagesLayer;
import Utils.TestLocatorsReader;
import org.base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllProductPage {
    private final By allProductsTitle = By.xpath(TestLocatorsReader.get("allProductsTitle"));
    private final By allProductsTID = By.xpath(TestLocatorsReader.get("firstProductID"));
    private final By firstProductName = By.xpath(TestLocatorsReader.get("firstProductName"));


    private final PredefinedActions actions;
    private final WebDriver driver;

    public AllProductPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new PredefinedActions(driver);
    }

    // Page Actions
    public String getPageTitle()
    {

        return actions.getElement(allProductsTitle,false).getText();

    }
    public String getTheText() {
        return actions.getElement(firstProductName,false).getText();

    }
}