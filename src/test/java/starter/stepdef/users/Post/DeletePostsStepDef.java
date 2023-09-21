package starter.stepdef.users.Post;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.gorest.posts.DeleteAPI;

public class DeletePostsStepDef {
    @Given("Delete single posts")
    public void deleteSinglePosts() {
        DeleteAPI.setDeleteSinglePosts();
    }

    @Given("Delete single posts {string} as invalid param")
    public void deleteSinglePostsByInvalidParam(String id) {
        DeleteAPI.setDeleteSinglePostsByInvalidParam(id);
    }

    @When("Send request delete posts")
    public void sendRequestDeletePosts() {
        System.out.println(DeleteAPI.DELETE_POSTS);
        SerenityRest.when().delete(DeleteAPI.DELETE_POSTS);
    }

    @When("Send request delete posts with invalid param")
    public void sendRequestDeletePostsWithInvalidParam() {
        SerenityRest.when()
                .delete(DeleteAPI.DELETE_POSTS_PARAM);
    }
}
