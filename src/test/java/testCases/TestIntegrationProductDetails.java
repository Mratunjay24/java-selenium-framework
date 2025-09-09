package testCases;
import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationProductDetails extends BaseClass {

    String firstProductName1;
    String text1;



    @Test
    public void completeTest() {
        TestAllProductDetailsFromUI uiTest = new TestAllProductDetailsFromUI();
        uiTest.setUp();
        text1 = uiTest.verifyText();
        System.out.println("Text from UI: " + text1);
        TestAllProductDetailsFromAPI apiTest = new TestAllProductDetailsFromAPI();
        apiTest.getRequest();
        firstProductName1 = apiTest.firstProductName;
        System.out.println("Product name from API: " + firstProductName1);
        Assert.assertEquals(text1, firstProductName1, "Product name mismatch between API and UI!");
        System.out.println("Integration test completed.");
    }

}
