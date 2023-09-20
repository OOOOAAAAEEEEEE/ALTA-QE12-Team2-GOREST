package starter.stepdef.users.Get;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.users.GetMethod.GetAPI;
import starter.utils.Constant;

import java.io.File;

public class GetUserStepDef {
    @Steps
    GetAPI getAllUserAPI;
    @Given("Get list user")
    public void getListUser() {
    }

    @When("Send request Get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(GetAPI.GET_USER);
    }

    @And("Validate JSON Schema {string}")
    public void validateJSONSchema(String schemaFile) {
        File json = new File(Constant.JSON_SCHEMA+schemaFile);
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//  SCENARIO 2: Get user detail with valid id
    @Given("Get user with valid id {int}")
    public void getUserWithValidId(int id) {
        getAllUserAPI.getDetailUser(id);
    }

    @When("Send request Get detail user")
    public void sendRequestGetDetailUser() {
        SerenityRest.when()
                .get(GetAPI.GET_DETAIL_USER);
    }

//   SCENARIO 3: Get user detail with invalid id
    @Given("Get detail user invalid id {string}")
    public void getDetailUserInvalidId(String id) {
        getAllUserAPI.getDetailUser(id);
    }

//    SCENARIO 4:Get all user with valid query param
    @Given("Get list user valid query param page <{int}> per page <{int}>")
    public void getListUserValidQueryParamPagePerPage(int page, int perpage) {
        getAllUserAPI.getAllUserWithValidQueryParam(page,perpage);

    }
    @When("Send request Get list user with param")
    public void sendRequestGetListUserWithParam() {
        SerenityRest.when()
                .get(GetAPI.GET_LIST_USER_WITH_PARAM);
    }

//    SCENARIO 5:Get all user with invalid query param

    @Given("Get list user invalid query param page {string} per page {string}")
    public void getListUserInvalidQueryParamPagePerPagePerPage(String page,String perpage) {
        getAllUserAPI.getAllUserWithInvalidQueryParam(page,perpage);
    }

}
