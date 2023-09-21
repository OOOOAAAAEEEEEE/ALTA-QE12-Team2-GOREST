package starter.stepdef.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.gorest.posts.PostAPI;
import starter.gorest.posts.PostsResponse;
import starter.utils.Constant;

import java.io.File;

public class PostPostsStepDef {
    @When("Send request post posts")
    public void sendRequestPostPosts() {
        SerenityRest.when().post(PostAPI.POST_CREATE_POSTS);
    }

    @And("Responses body should be {string} as title and {string} as body")
    public void responsesBodyShouldBeAsTitleAndAsBody(String title, String body) {
        SerenityRest.then()
                .body(PostsResponse.POSTS_TITLE, Matchers.equalTo(title))
                .body(PostsResponse.POSTS_BODY, Matchers.equalTo(body));

    }

    @Given("post create user with {string} and without token")
    public void postCreateUserWithAndWithoutToken(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PostAPI.setPostCreatePosts(jsonFile);
    }

    @And("Responses body should be show error {string}")
    public void responsesBodyShouldBeShowError(String message) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG, Matchers.equalTo(message));
    }


    @And("Responses body should be show error {string} type one")
    public void responsesBodyShouldBeShowErrorType(String message) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG_NOT_ARRAY, Matchers.equalTo(message));
    }
}
