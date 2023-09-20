package starter.stepdef.users.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.users.PostMethod.PostAPI;
import starter.gorest.users.UserResponses;
import starter.utils.Constant;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepdef {
    @Steps
    PostAPI postValidBodyAPI;

    @Given("Post create user with {string}")
    public void postCreateUserWith(String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        postValidBodyAPI.postCreateUser(json);
    }

    @When("Send request Create user")
    public void sendRequestCreateUser() {
        SerenityRest.when().post(PostAPI.URL_POST_USER);
    }

    @Then("Status code {int}")
    public void statusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Responses body should be name {string} and email {string}")
    public void hasValidResponse(String name, String email) {
        SerenityRest.then()
                .body(UserResponses.NAME, equalTo(name))
                .body(UserResponses.EMAIL, equalTo(email));
    }

    @And("Validate JSON schema {string}")
    public void validateJSONSchema(String schemaFile) {
        File json = new File(Constant.JSON_SCHEMA+schemaFile);
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
