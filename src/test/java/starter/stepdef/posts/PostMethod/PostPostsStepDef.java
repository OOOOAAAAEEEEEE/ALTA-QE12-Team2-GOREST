package starter.stepdef.posts.PostMethod;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.gorest.posts.PostsResponse;
import starter.stepdef.GeneralMethod;

public class PostPostsStepDef {
    @Given("Responses body should be {string} as title and {string} as body")
    public void responsesBodyShouldBeAsTitleAndAsBody(String title, String body) {
        SerenityRest.and()
                .body(PostsResponse.POST_TITLE, Matchers.equalTo(title))
                .and()
                .body(PostsResponse.POST_BODY, Matchers.equalTo(body));
    }

    @When("Send request Post method")
    public void sendRequestPostMethod() {
        SerenityRest.when()
                .post(GeneralMethod.endpoint);
    }
}
