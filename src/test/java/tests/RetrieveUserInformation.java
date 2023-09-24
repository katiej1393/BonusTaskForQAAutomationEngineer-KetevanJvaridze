package tests;

import org.testng.Assert;
import testData.Constants;
import io.restassured.response.Response;
import modelClasses.authorize.AuthorizeRequest;
import modelClasses.authorize.AuthorizeResponse;
import modelClasses.info.InfoResponse;
import org.testng.annotations.Test;
import steps.AuthorizeSteps;
import steps.InfoSteps;

public class RetrieveUserInformation {

    AuthorizeSteps authorizeSteps = new AuthorizeSteps();
    InfoSteps infoSteps = new InfoSteps();

    @Test
    public void retrieveUserInformationValidSession(){
        AuthorizeRequest authorizeRequest;
        authorizeRequest = authorizeSteps.createAuthorizationRequest(Constants.validUsername,Constants.validPassword);
        Response responseAuth = authorizeSteps.sendAuthorizeRequest(authorizeRequest);
        AuthorizeResponse authorizeResponse;
        authorizeResponse = responseAuth.as(AuthorizeResponse.class);
        Response responseInfo;
        responseInfo = infoSteps.sendInfoRequest("Authorization",authorizeResponse.getToken(),Constants.basePathInfo);
        InfoResponse infoResponse = new InfoResponse();
        infoResponse = responseInfo.as(InfoResponse.class);
        Assert.assertEquals(infoResponse.getMessage(),Constants.message,"message value assertion");
    }

    @Test
    public void retrieveUserInformationInValidSession(){
        InfoSteps infoSteps = new InfoSteps();
        Response responseInfo;
        responseInfo = infoSteps.sendInfoRequest("Authorization","","");
        Assert.assertEquals(responseInfo.getStatusCode(),403,"Status code assertion");
    }
}
