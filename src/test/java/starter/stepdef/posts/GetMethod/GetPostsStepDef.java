package starter.stepdef.posts.GetMethod;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.gorest.posts.FetchedDataFromGet;
import starter.stepdef.GeneralMethod;
import starter.utils.Constant;

public class GetPostsStepDef {


    @When("Send request get method list all of posts")
    public void sendRequestGetMethodListAllOfPosts() {
        Response res = SerenityRest
                .given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .when()
                .get(GeneralMethod.endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        FetchedDataFromGet.ID_POSTS = res.asString().substring(7,12);
    }
}
