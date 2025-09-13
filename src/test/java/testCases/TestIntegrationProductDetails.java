package testCases;
import basePackage.BaseClass;
import org.base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesLayer.AllProductPage;

public class TestIntegrationProductDetails extends BaseClass {

    String firstProductName1;
    String text1;
    AllProductPage allProductPage;

    @BeforeMethod
    public void setUpPage() {
        WebDriver driver;
        driver = setUp();
        allProductPage = new AllProductPage(driver);
    }

    @Test
    public void completeTest() {
        text1 = allProductPage.getTheText();
        System.out.println("Text from UI: " + text1);
        TestAllProductDetailsFromAPI apiTest = new TestAllProductDetailsFromAPI();
        apiTest.getRequest();
        firstProductName1 = apiTest.firstProductName;
        System.out.println("Product name from API: " + firstProductName1);
        Assert.assertEquals(text1, firstProductName1, "Product name mismatch between API and UI!");
        System.out.println("Integration test completed.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
