package starter.gorest.users.PostMethod;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

import net.thucydides.core.annotations.Steps;
import starter.gorest.users.UserPayload;
import starter.utils.Constant;


public class PostAPI {
    public static final String URL_POST_USER = Constant.BASE_URL + "/public/v2/users";

    @Step("set body request")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer "+ Constant.TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("without body")
    public void postWithoutBody(String name,String email,String gender,String status){
        UserPayload body = new UserPayload(name, email, gender, status);
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

}
