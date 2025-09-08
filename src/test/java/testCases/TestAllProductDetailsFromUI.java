package testCases;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesLayer.allProductPage;

public class
TestCase1 extends allProductPage {

	@BeforeTest
	public void startTest() {
		setUrl();
	}
	
	@Test
	public void verifyTitle() {

		String titleName = getTheTitle();
        System.out.println("The title of the page is: " + titleName);
	}
    @Test
    public void verifyText() {
        String text = getTheText("//h2[text()='All Products']");
        System.out.println("The text on the page is: " + text);
        text = getTheText("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]");
        System.out.println("The text on the page is: " + text);
        text = getTheText("//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/preceding-sibling::p[1]");
        System.out.println("The text on the page is: " + text);
        Assert.assertEquals(text, "Blue Top");
    }
	@AfterTest
	public void endTest() {

		// closeBrowser();
	}

}
