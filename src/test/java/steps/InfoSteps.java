package steps;

import modelClasses.info.InfoResponse;
import org.testng.asserts.SoftAssert;
import testData.Constants;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class InfoSteps extends BaseStep{

    public Response sendInfoRequest(String headerName, String headerValue, String basePath){
        RequestSpecification requestSpecification;
        requestSpecification = given().header(headerName,headerValue).baseUri(Constants.baseURI)
                .basePath(basePath)
                .accept(JSON);
        return get(requestSpecification);
    }
}
