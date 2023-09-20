package starter.gorest.posts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class PostAPI {

    public static final String POST_CREATE_POSTS = Constant.BASE_URL + "/public/v2/posts";

    @Step("Post create without token")
    public static void setPostCreatePosts(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
