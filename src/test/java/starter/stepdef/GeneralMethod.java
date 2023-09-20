package starter.stepdef;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import starter.gorest.posts.SetBaseUrlAndPath;
import starter.utils.Constant;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.*;

public class GeneralMethod {

    @Given("Base URL is base url and path {string}")
    public void baseURLIsAndSetPath(String path) {
        SetBaseUrlAndPath.setBaseUrlAndPathMethod(path);
    }

    @Given("Passing {string} into body and set contentType as Json")
    public void passingIntoBodyAndSetContentTypeAsJson(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);

        given().contentType(ContentType.JSON).body(jsonFile);
    }


}
