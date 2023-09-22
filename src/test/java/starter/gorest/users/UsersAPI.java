package starter.gorest.users;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class UsersAPI {

    public static String GET_ID = Constant.BASE_URL+"/public/v2/users?page=1&per_page=1";

    @Step("Get users id")
    public static String getUsersId() {
        String responses = SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .queryParam(Constant.PAGE, 1)
                .queryParam(Constant.PERPAGE, 1)
                .when().get(UsersAPI.GET_ID)
                .then().extract().response().asString();
        System.out.println(responses.substring(7,14));
        return responses.substring(7,14);
    }

    public static String id = getUsersId();
    public static String DELETE_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    public static String DELETE_USER_DYNAMIC = Constant.BASE_URL+"/public/v2/users/"+id;
    public static String GET_USER = Constant.BASE_URL+"/public/v2/users/";
    public static String GET_LIST_USER_WITH_PARAM = Constant.BASE_URL+"/public/v2/users?page={page}&per_page={perpage}";
    public static String GET_DETAIL_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    public static final String PATCH_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    public static final String PATCH_USER_DYNAMIC = Constant.BASE_URL+"/public/v2/users/"+id;
    public static final String URL_POST_USER = Constant.BASE_URL + "/public/v2/users";
    public static final String PUT_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    public static final String PUT_USER_DYNAMIC = Constant.BASE_URL+"/public/v2/users/"+id;




//    POST METHOD
    @Step("set body request")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("without body")
    public void postWithoutBody(String name,String email,String gender,String status){
        UsersPayload body = new UsersPayload(name, email, gender, status);
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("set WithoutToken")
    public void postWithoutToken(File json) {
        SerenityRest.given()
                .body(json);
    }






//    GET METHOD
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





//    PATCH METHOD
    @Step("patch valid id")
    public void patchValidId(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("patch valid id")
    public void patchValidId(File json){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("patch invalid id")
    public void patchInvalidId(String id,File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Valid id with invalid body")
    public void patchValidIdWithInvalidBody(int id,String name,String email,String gender,String status){
        UsersPayload body = new UsersPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("Invalid id with invalid body")
    public void patchInvalidIdWithInvalidBody(String id,String name,String email,String gender,String status){
        UsersPayload body = new UsersPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }





//    PUT METHOD
    @Step("put valid id")
    public void putValidId(int id,File json){
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);


    }
    @Step("put invalid id")
    public void putInvalidId(String id,File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Valid id with invalid body")
    public void putValidIdWithInvalidBody(int id,String name,String email,String gender,String status){
        UsersPayload body = new UsersPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("Invalid id with invalid body")
    public void putInvalidIdWithInvalidBody(String id,String name,String email,String gender,String status){
        UsersPayload body = new UsersPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }





//    DELETE METHOD
    @Step("Delete valid id")
    public void deleteValidId(){
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON);


    }
    @Step("Delete valid id")
    public void deleteValidIdStatic(int id){
        SerenityRest.given().headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);


    }
    @Step("Delete invalid id")
    public void deleteInvalidId(String id){
        SerenityRest.given().pathParam("id",id);
    }

}
