package testCases;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class TestApiAllProductPage {
    @Test
    public void getRequest() {
        // set base URI
        RestAssured.baseURI = "https://automationexercise.com/api";
        // get RequestSpecification of the request
        RequestSpecification request = RestAssured.given();
        // make a GET request
        Response response = request.get("/productsList");
        // print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        // extract json value
        String firstProductName = response.jsonPath().getString("products[0].name");
        System.out.println("First product name: " + firstProductName);
        //
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(firstProductName, "Blue Top", "Product name mismatch!");
        // response.then().assertThat().body("products[0].name", equalTo("Blue Top"));
    }
}
