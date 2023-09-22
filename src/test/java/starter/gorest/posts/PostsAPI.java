package starter.gorest.posts;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class PostsAPI {

    //GET ID DYNAMICALLY
    public static String id = getPostsId();

    public static final String POST_CREATE_POSTS = Constant.BASE_URL + "/public/v2/posts";

    public static final String GET_POSTS_LIST = Constant.BASE_URL + "/public/v2/posts";

    public static final String GET_POSTS_LIST_BY_USER = Constant.BASE_URL + "/public/v2/users/5180432/posts";

    public static final String GET_SINGLE_POST = Constant.BASE_URL + "/public/v2/posts/{id}";

    public static String PUT_UPDATE_POSTS_INVALID = Constant.BASE_URL + "/public/v2/posts/{id}";

    public static String PUT_UPDATE_POSTS = Constant.BASE_URL + "/public/v2/posts/" + id;

    public static String DELETE_POSTS = Constant.BASE_URL + "/public/v2/posts/" + id;

    public static String DELETE_POSTS_PARAM = Constant.BASE_URL + "/public/v2/posts/{id}";


    //POST STEP !!!!!!!!!!!!


    @Step("Post create without token")
    public static void setPostCreatePosts(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    //GET STEP !!!!!!!!!!!!!!


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
                .when().get(GET_POSTS_LIST)
                .then().extract().response().asString();

        return responses.substring(7, 12);
    }


    //PUT STEPS !!!!!!!!!!!!


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


    //DELETE STEPS  !!!!!!!!!!!!


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
