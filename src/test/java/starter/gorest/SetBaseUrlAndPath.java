package starter.gorest;


import net.thucydides.core.annotations.Step;

import net.serenitybdd.rest.SerenityRest;
import starter.utils.Constant;

public class SetBaseUrlAndPath {
    @Step("Set base url and path")
    public static void setBaseUrlAndPathMethod(String path){
        SerenityRest.given()
                .baseUri(Constant.BASE_URL)
                .basePath(path);
    }

}
