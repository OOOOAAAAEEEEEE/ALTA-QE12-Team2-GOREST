package starter.stepdef.posts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.gorest.posts.PutAPI;
import starter.utils.Constant;

import java.io.File;

public class PatchPostsStepDef {

    @When("Send request patch posts")
    public void sendRequestPutPosts() {
        SerenityRest.when().patch(PutAPI.PUT_UPDATE_POSTS);
    }


    @When("Send request patch posts with invalid param")
    public void sendRequestPutPostsWithInvalidParam() {
        SerenityRest.when().patch(PutAPI.PUT_UPDATE_POSTS_INVALID);
    }


    @When("Send request patch posts without id on param")
    public void sendRequestPutPostsWithoutIdOnParam() {
        SerenityRest.when().patch(Constant.BASE_URL + "/public/v2/posts");
    }
}
