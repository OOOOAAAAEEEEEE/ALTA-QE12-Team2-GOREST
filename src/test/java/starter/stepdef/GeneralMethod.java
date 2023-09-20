package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.Constant;

import java.io.File;

public class GeneralMethod {

    public static String endpoint;

    @Given("Base URL and {string} as path")
    public void baseURLIsAndSetPath(String path) {
        endpoint = Constant.BASE_URL+path;
    }

    @Given("Base URL and {string} as path and {string} as pathParam and {string} as queryParam")
    public void baseURLAndAsPathAndAsPathParamAndAsQueryParam(String path, String pathParam, String queryParam) {
        endpoint = Constant.BASE_URL + path + pathParam + queryParam;
    }

    @Given("Passing {string} as json request into body and set contentType as Json")
    public void passingIntoBodyAndSetContentTypeAsJson(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);

        SerenityRest.given()
            .headers("Authorization", "Bearer " + Constant.TOKEN)
            .contentType(ContentType.JSON)
            .body(jsonFile);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int code) {
        SerenityRest.then().statusCode(code);
    }



//    @And("Validate JSON schema {string}")
//    public void validateJSONSchema(String jsonPath) {
//        File jsonFile = new File(Constant.JSON_SCHEMA+jsonPath);
//        SerenityRest.then()
//                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
//    }
}
