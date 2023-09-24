package steps;

import testData.Constants;
import io.restassured.config.ParamConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import modelClasses.authorize.AuthorizeRequest;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthorizeSteps extends BaseStep{

    public Response sendAuthorizeRequest(AuthorizeRequest authorizeRequest){

        RequestSpecification requestSpecification;
        requestSpecification = given().baseUri(Constants.baseURI)
                .basePath("/authorize")
                .contentType(JSON)
                .config(config.paramConfig((ParamConfig.paramConfig().replaceAllParameters())));
        requestSpecification.body(authorizeRequest);
        return post(requestSpecification);
    }

    public AuthorizeRequest createAuthorizationRequest(String username, String password){
        AuthorizeRequest authorizeRequest = new AuthorizeRequest();
        authorizeRequest.setUsername(username);
        authorizeRequest.setPassword(password);
        return authorizeRequest;
    }
}
