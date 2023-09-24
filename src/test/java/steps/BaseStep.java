package steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseStep {

    public Response post(RequestSpecification requestSpecification) {
        return requestSpecification.log().all().post().then().log().all().extract().response();
    }

    public Response get(RequestSpecification requestSpecification) {
        return requestSpecification.log().all().get().then().log().all().extract().response();
    }
}
