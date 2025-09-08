package testCases;
import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesLayer.AllProductPage;

public class
TestAllProductDetailsFromUI extends BaseClass {
    String text = "";
    AllProductPage allProductPage;
    WebDriver driver;

    @Override @BeforeClass
    public void setUp() {
        super.setUp();
        driver = getDriver();
        allProductPage = new AllProductPage(driver);
    }

    @Test
	public void verifyTitle() {

		String titleName = allProductPage.getPageTitle(driver);
        System.out.println("The title of the page is: " + titleName);
	}
    @Test
    public void verifyText() {
        text = allProductPage.getTheText();
        Assert.assertEquals(text, "Blue Top");
    }

    @Override @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
