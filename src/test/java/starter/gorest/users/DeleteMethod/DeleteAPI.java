package starter.gorest.users.DeleteMethod;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

public class DeleteAPI {
    public static String DELETE_USER = Constant.BASE_URL+"/public/v2/users/{id}";
    @Step("Delete valid id")
    public void deleteValidId(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Delete invalid id")
    public void deleteInvalidId(String id){
        SerenityRest.given().pathParam("id",id);
    }

}
