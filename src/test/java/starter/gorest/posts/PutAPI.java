package starter.gorest.posts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class PutAPI {

    public static String id = GetAPI.getPostsId();

    public static String PUT_UPDATE_POSTS_INVALID = Constant.BASE_URL + "/public/v2/posts/{id}";

    public static String PUT_UPDATE_POSTS = Constant.BASE_URL + "/public/v2/posts/" + id;

    @Step("Put update posts invalid")
    public static void putUpdatePostsInvalid(File json, String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .pathParam(Constant.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update posts")
    public static void putUpdatePosts(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update posts without token")
    public static void putUpdatePostsWithoutToken(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
