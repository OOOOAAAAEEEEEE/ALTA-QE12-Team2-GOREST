package starter.gorest.users.PutMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.gorest.users.UserPayload;
import starter.utils.Constant;

import java.io.File;

public class PutAPI {
    public static final String PUT_USER = Constant.BASE_URL+"/public/v2/users/{id}";
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
        UserPayload body = new UserPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }
    @Step("Invalid id with invalid body")
    public void putInvalidIdWithInvalidBody(String id,String name,String email,String gender,String status){
        UserPayload body = new UserPayload(name, email, gender, status);
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(body, ObjectMapperType.GSON);
    }

}
