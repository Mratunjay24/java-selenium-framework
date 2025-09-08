package testCases;
import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesLayer.AllProductPage;

public class
TestAllProductDetailsFromUI extends BaseClass {
    String text = "";
    AllProductPage allProductPage;

    @Override @BeforeClass
    public void setUp() {
        super.setUp();
        allProductPage = new AllProductPage();
    }

    @Test
	public void verifyTitle() {

		String titleName = allProductPage.getPageTitle();
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
