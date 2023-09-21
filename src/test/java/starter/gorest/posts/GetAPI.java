package starter.gorest.posts;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import starter.utils.Constant;

import java.io.File;

public class GetAPI {

    public static final String GET_POSTS_LIST = Constant.BASE_URL + "/public/v2/posts";

    public static final String GET_POSTS_LIST_BY_USER = Constant.BASE_URL + "/public/v2/users/5180432/posts";

    public static final String GET_SINGLE_POST = Constant.BASE_URL + "/public/v2/posts/{id}";

    @Step("Get single posts")
    public void setGetSinglePost(Object id, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .pathParam(Constant.ID, id)
                .body(json);
    }

    @Step("Get list post filter by user_id")
    public static void getListPostFilterByUserId() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list post with query string")
    public static void setGetPostsList(String page, String perpage) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .queryParam(Constant.PAGE, page)
                .queryParam(Constant.PERPAGE, perpage);
    }

    @Step("Get single post")
    public static void setGetSinglePost(String id) {
        SerenityRest.given()
                .pathParam(Constant.ID, id);
    }

    @Step("Get posts id")
    public static String getPostsId() {
        String responses = SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .queryParam(Constant.PAGE, 1)
                .queryParam(Constant.PERPAGE, 1)
                .when().get(GetAPI.GET_POSTS_LIST)
                .then().extract().response().asString();

        return responses.substring(7, 12);
    }


}
