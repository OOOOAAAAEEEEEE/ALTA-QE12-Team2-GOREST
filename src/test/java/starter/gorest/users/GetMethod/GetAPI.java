package starter.gorest.users.GetMethod;


import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class GetAPI {
    public static String GET_USER = Constant.BASE_URL+"/public/v2/users/";
    public static String GET_LIST_USER_WITH_PARAM = Constant.BASE_URL+"/public/v2/users?page={page}&per_page={perpage}";
    public static String GET_DETAIL_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    @Step("Get all user")
    public void getAllUser(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get detail user")
    public void getDetailUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get detail user")
    public void getDetailUser(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get all user with valid query param")
    public void getAllUserWithValidQueryParam(int page,int perpage){
        SerenityRest.given()
                .pathParam("page",page)
                .pathParam("perpage",perpage);

    }
    @Step("Get all user with valid query param")
    public void getAllUserWithInvalidQueryParam(String page,String perpage){
        SerenityRest.given()
                .pathParam("page",page)
                .pathParam("perpage",perpage);

    }
}
