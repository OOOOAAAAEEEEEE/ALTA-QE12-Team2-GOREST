package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.Constant;

import java.io.File;

public class GeneralMethod {

    public String endpoint;


    @Given("Base URL and path {string}")
    public void baseURLIsAndSetPath(String path) {
        endpoint = Constant.BASE_URL+path;
    }

    @Given("Passing {string} as json request into body and set contentType as Json")
    public void passingIntoBodyAndSetContentTypeAsJson(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);

        SerenityRest.given()
            .headers("Authorization", "Bearer " + Constant.TOKEN)
            .contentType(ContentType.JSON)
            .body(jsonFile);
    }

    @When("Send request from given endpoint")
    public void sendRequestFromGivenEndpoint() {
        SerenityRest.when().post(endpoint);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int code) {
        SerenityRest.then().statusCode(code);
    }
}
