package starter.gorest.posts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.Constant;

public class DeleteAPI {
    public static String id = GetAPI.getPostsId();

    public static String DELETE_POSTS = Constant.BASE_URL + "/public/v2/posts/" + id;

    public static String DELETE_POSTS_PARAM = Constant.BASE_URL + "/public/v2/posts/{id}";

    @Step("Delete single posts")
    public static void setDeleteSinglePosts() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Delete single posts by invalid param")
    public static void setDeleteSinglePostsByInvalidParam(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .pathParam(Constant.ID, id);
    }

}
