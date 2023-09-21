package starter.stepdef.posts;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.hamcrest.Matchers;
import starter.gorest.posts.PostsAPI;
import starter.gorest.posts.PostsResponse;
import starter.utils.Constant;

import java.io.File;

public class PostsStepDef {


    //POST STEP DEFSSSS !!!!!!!!!!


    @When("Send request post posts")
    public void sendRequestPostPosts() {
        SerenityRest.when().post(PostsAPI.GET_POSTS_LIST_BY_USER);
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
        PostsAPI.setPostCreatePosts(jsonFile);
    }


    @And("Responses body should be show error {string}")
    public void responsesBodyShouldBeShowError(String message) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG, Matchers.equalTo(message));
    }


    @And("Responses body should be show error {string} type one")
    public void responsesBodyShouldBeShowErrorType(String message) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG_NOT_ARRAY, Matchers.equalTo(message));
    }


    //GET STEP DEFSSSS !!!!!!!!!!!


    @Given("Get list posts")
    public void getListPosts() {

    }


    @When("Send request get list posts")
    public void sendRequestGetPosts() {
        SerenityRest.given()
                .get(PostsAPI.GET_POSTS_LIST);
    }


    @Given("Get list posts with {string} as page and {string} as perpage")
    public void getListPostsWithAsPageAndAsPerpage(String page, String perpage) {
        PostsAPI.setGetPostsList(page, perpage);
    }


    @Given("Get single post by id {string}")
    public void getSinglePostById(String id) {
        PostsAPI.setGetSinglePost(id);
    }


    @When("Send request get single posts")
    public void sendRequestGetSinglePosts() {
        SerenityRest.when()
                .get(PostsAPI.GET_SINGLE_POST);
    }


    @And("Responses body should be {string}")
    public void responsesBodyShouldBe(String msg) {
        SerenityRest.then().body(PostsResponse.POSTS_MSG_NOT_ARRAY, Matchers.equalTo(msg));
    }


    @Given("Get list posts filter by user_id")
    public void getListPostsFilterByUser_id() {
        PostsAPI.getListPostFilterByUserId();
    }


    @When("Send request get list posts by user_id")
    public void sendRequestGetListPostsByUser_id() {
        SerenityRest.when().get(PostsAPI.GET_POSTS_LIST_BY_USER);
    }


    //PUT STEP DEFSSS !!!!!!!!!!!


    @Given("Update user with {string}")
    public void putUpdateUserWith(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PostsAPI.putUpdatePosts(jsonFile);
    }

    @Given("Update user with {string} as json and {string} as id")
    public void putUpdateUserInvalid(String jsonPath, String id){
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PostsAPI.putUpdatePostsInvalid(jsonFile, id);
    }

    @When("Send request put posts")
    public void sendRequestPutPosts() {
        System.out.println(PostsAPI.PUT_UPDATE_POSTS);
        SerenityRest.when().put(PostsAPI.PUT_UPDATE_POSTS);
    }


    @When("Send request put posts with invalid param")
    public void sendRequestPutPostsWithInvalidParam() {
        SerenityRest.when().put(PostsAPI.PUT_UPDATE_POSTS_INVALID);
    }

    @Given("Update user with {string} without token")
    public void putUpdateUserWithWithoutToken(String jsonPath) {
        File jsonFile = new File(Constant.REQ_BODY + jsonPath);
        PostsAPI.putUpdatePostsWithoutToken(jsonFile);
    }

    @When("Send request put posts without id on param")
    public void sendRequestPutPostsWithoutIdOnParam() {
        SerenityRest.when().put(Constant.BASE_URL + "/public/v2/posts");
    }


    //PATCH STEP DEFSSS!!!!!!!


    @When("Send request patch posts")
    public void sendRequestPatchPosts() {
        SerenityRest.when().patch(PostsAPI.PUT_UPDATE_POSTS);
    }


    @When("Send request patch posts with invalid param")
    public void sendRequestPatchPostsWithInvalidParam() {
        SerenityRest.when().patch(PostsAPI.PUT_UPDATE_POSTS_INVALID);
    }


    @When("Send request patch posts without id on param")
    public void sendRequestPatchPostsWithoutIdOnParam() {
        SerenityRest.when().patch(Constant.BASE_URL + "/public/v2/posts");
    }


    //DELETE STEP DEFS !!!!!!!!!


    @Given("Delete single posts")
    public void deleteSinglePosts() {
        PostsAPI.setDeleteSinglePosts();
    }

    @Given("Delete single posts {string} as invalid param")
    public void deleteSinglePostsByInvalidParam(String id) {
        PostsAPI.setDeleteSinglePostsByInvalidParam(id);
    }

    @When("Send request delete posts")
    public void sendRequestDeletePosts() {
        System.out.println(PostsAPI.DELETE_POSTS);
        SerenityRest.when().delete(PostsAPI.DELETE_POSTS);
    }

    @When("Send request delete posts with invalid param")
    public void sendRequestDeletePostsWithInvalidParam() {
        SerenityRest.when()
                .delete(PostsAPI.DELETE_POSTS_PARAM);
    }


}
