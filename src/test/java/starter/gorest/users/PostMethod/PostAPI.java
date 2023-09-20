package starter.gorest.users.PostMethod;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

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
}
