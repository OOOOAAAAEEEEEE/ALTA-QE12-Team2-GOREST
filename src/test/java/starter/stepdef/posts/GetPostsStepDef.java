package starter.stepdef.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.gorest.posts.GetAPI;
import starter.gorest.posts.PostsResponse;

public class GetPostsStepDef {
    @Given("Get list posts")
    public void getListPosts() {

    }

    @When("Send request get list posts")
    public void sendRequestGetPosts() {
        SerenityRest.given()
                .get(GetAPI.GET_POSTS_LIST);
    }

    @Given("Get list posts with {string} as page and {string} as perpage")
    public void getListPostsWithAsPageAndAsPerpage(String page, String perpage) {
        GetAPI.setGetPostsList(page, perpage);
    }


    @Given("Get single post by id {string}")
    public void getSinglePostById(String id) {
        GetAPI.setGetSinglePost(id);
    }

    @When("Send request get single posts")
    public void sendRequestGetSinglePosts() {
        SerenityRest.when()
                .get(GetAPI.GET_SINGLE_POST);
    }

    @And("Responses body should be {string}")
    public void responsesBodyShouldBe(String msg) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG_NOT_ARRAY, Matchers.equalTo(msg));
    }

    @Given("Get list posts filter by user_id")
    public void getListPostsFilterByUser_id() {
        GetAPI.getListPostFilterByUserId();
    }

    @When("Send request get list posts by user_id")
    public void sendRequestGetListPostsByUser_id() {
        SerenityRest.when().get(GetAPI.GET_POSTS_LIST_BY_USER);
    }
}
