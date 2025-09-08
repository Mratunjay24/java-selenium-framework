package testCases;

import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class TestIntegrationProductDetails extends BaseClass {

    String firstProductName1;
    String text1;



    @Test
    public void completeTest() {
        TestAllProductDetailsFromUI uiTest = new TestAllProductDetailsFromUI();
        uiTest.setUp();
        uiTest.verifyText();
        text1 = uiTest.text;
        System.out.println("Text from UI: " + text1);
        TestAllProductDetailsFromAPI apiTest = new TestAllProductDetailsFromAPI();
        apiTest.getRequest();
        firstProductName1 = apiTest.firstProductName;
        System.out.println("Product name from API: " + firstProductName1);
        Assert.assertEquals(text1, firstProductName1, "Product name mismatch between API and UI!");
        System.out.println("Integration test completed.");
    }

    @Override @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
