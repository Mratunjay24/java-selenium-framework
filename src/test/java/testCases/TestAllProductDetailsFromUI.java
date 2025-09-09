package testCases;
import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesLayer.AllProductPage;

public class
TestAllProductDetailsFromUI extends BaseClass {

    AllProductPage allProductPage;

    @BeforeMethod
    public void setUp() {
        allProductPage = new AllProductPage(getDriver());
    }

    @Test
	public void verifyTitle() {

		String titleName = allProductPage.getPageTitle();
        System.out.println("The title of the page is: " + titleName);
	}
    @Test
    public String verifyText() {
        String text = allProductPage.getTheText();
        Assert.assertEquals(text, "Blue Top");
        return text;
    }
}
