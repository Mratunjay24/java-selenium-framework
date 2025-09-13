package testCases;
import basePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesLayer.AllProductPage;

public class
TestAllProductDetailsFromUI extends BaseClass {

    AllProductPage allProductPage;

    @BeforeMethod
    public void setUpPage() {
        WebDriver driver;
         driver = setUp();
        allProductPage = new AllProductPage(driver);
    }

    @Test
	public void verifyTitle() {
		String titleName = allProductPage.getPageTitle();
        System.out.println("The title of the page is: " + titleName);
	}

    @Test
    public void verifyText() {
        String text = allProductPage.getTheText();
        Assert.assertEquals(text, "Blue Top");
    }
}
