package starter.stepdef.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.gorest.posts.PutAPI;
import starter.utils.Constant;

import java.io.File;

public class PutPostsStepDef {
    @Given("Update user with {string}")
    public void putUpdateUserWith(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PutAPI.putUpdatePosts(jsonFile);
    }

    @Given("Update user with {string} as json and {string} as id")
    public void putUpdateUserInvalid(String jsonPath, String id){
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PutAPI.putUpdatePostsInvalid(jsonFile, id);
    }

    @When("Send request put posts")
    public void sendRequestPutPosts() {
        System.out.println(PutAPI.PUT_UPDATE_POSTS);
        SerenityRest.when().put(PutAPI.PUT_UPDATE_POSTS);
    }


    @When("Send request put posts with invalid param")
    public void sendRequestPutPostsWithInvalidParam() {
        SerenityRest.when().put(PutAPI.PUT_UPDATE_POSTS_INVALID);
    }

    @Given("Update user with {string} without token")
    public void putUpdateUserWithWithoutToken(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PutAPI.putUpdatePostsWithoutToken(jsonFile);
    }

    @When("Send request put posts without id on param")
    public void sendRequestPutPostsWithoutIdOnParam() {
        SerenityRest.when().put(Constant.BASE_URL + "/public/v2/posts");
    }
}
