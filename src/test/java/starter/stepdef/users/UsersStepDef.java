package starter.stepdef.users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.users.UsersAPI;
import starter.gorest.users.UsersResponse;
import starter.utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UsersStepDef {

//    GET METHOD
@Steps
UsersAPI usersAPI;
    @Given("Get list user")
    public void getListUser() {
    }

    @When("Send request Get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(UsersAPI.GET_USER);
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
        usersAPI.getDetailUser(id);
    }

    @When("Send request Get detail user")
    public void sendRequestGetDetailUser() {
        SerenityRest.when()
                .get(UsersAPI.GET_DETAIL_USER);
    }

    //   SCENARIO 3: Get user detail with invalid id
    @Given("Get detail user invalid id {string}")
    public void getDetailUserInvalidId(String id) {
        usersAPI.getDetailUser(id);
    }

    //    SCENARIO 4:Get all user with valid query param
    @Given("Get list user valid query param page <{int}> per page <{int}>")
    public void getListUserValidQueryParamPagePerPage(int page, int perpage) {
        usersAPI.getAllUserWithValidQueryParam(page,perpage);

    }
    @When("Send request Get list user with param")
    public void sendRequestGetListUserWithParam() {
        SerenityRest.when()
                .get(UsersAPI.GET_LIST_USER_WITH_PARAM);
    }

//    SCENARIO 5:Get all user with invalid query param

    @Given("Get list user invalid query param page {string} per page {string}")
    public void getListUserInvalidQueryParamPagePerPagePerPage(String page,String perpage) {
        usersAPI.getAllUserWithInvalidQueryParam(page,perpage);
    }
//    POSH METHOD
@Given("Post create user with {string}")
public void postCreateUserWith(String bodyFile) {
    File json = new File(Constant.REQ_BODY+ bodyFile);
    usersAPI.postCreateUser(json);
}

    @When("Send request Create user")
    public void sendRequestCreateUser() {
        SerenityRest.when().post(UsersAPI.URL_POST_USER);
    }

    @Then("Status code {int}")
    public void statusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Responses body should be name {string} and email {string}")
    public void hasValidResponse(String name, String email) {
        SerenityRest.then()
                .body(UsersResponse.NAME, equalTo(name))
                .body(UsersResponse.EMAIL, equalTo(email));
    }
    //    SCENARIO 4: Post with invalid body
    @Given("Post create user with name {string} email {string} gender {string} status {string}")
    public void postCreateUserWithNameEmailGenderStatus(String name, String email, String gender,String status) {
        usersAPI.postWithoutBody(name,email,gender,status);
    }
    //   SCENARIO 5: Post without Authorization token
    @Given("Post create user without authorization token with {string}")
    public void postCreateUserWithoutAuthorizationTokenWith(String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        usersAPI.postWithoutToken(json);
    }

    @And("Responses body message should be {string}")
    public void responsesBodyMessageShouldBe(String message) {
        SerenityRest.then()
                .body(UsersResponse.MESSAGE, equalTo(message));
    }
//    PUT METHOD
    @Given("Put edit user valid body {string}")
    public void putEditUserValidBody(String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        usersAPI.patchValidId(json);
    }
    @When("Send request Edit user")
    public void sendRequestEditUser() {
        SerenityRest.when()
                .put(UsersAPI.PUT_USER_DYNAMIC);
    }

    @And("Responses body message should be name {string} and email {string}")
    public void responsesBodyMessageShouldBeNameAndEmail(String name, String email) {
        SerenityRest.then()
                .body(UsersResponse.NAME, equalTo(name))
                .body(UsersResponse.EMAIL, equalTo(email));
    }
    //  SCENARIO 2:Put user with invalid id
    @Given("Edit user with invalid id {string} and body {string}")
    public void editUserWithInvalidIdAndBody(String id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        usersAPI.putInvalidId(id,json);
    }
    @When("Send request put edit user with static id")
    public void sendRequestPutEditUserWithStaticId() {
        SerenityRest.when()
                .put(UsersAPI.PUT_USER);

    }
    //  SCENARIO 3:
    @Given("Put edit user with valid id {int} and invalid body name {string} email {string} gender {string} status {string}")
    public void putEditUserWithValidIdAndInvalidBodyNameEmailGenderStatus(int id, String name, String email, String gender, String status) {
        usersAPI.putValidIdWithInvalidBody(id,name,email,gender,status);
    }
    //    SCENARIO 4:
    @Given("Put edit user with invalid id {string} and invalid body name {string} email {string} gender {string} status {string}")
    public void putEditUserWithInvalidIdAndInvalidBodyNameEmailGenderStatus(String id, String name, String email, String gender, String status) {
        usersAPI.putInvalidIdWithInvalidBody(id,name,email,gender,status);
    }
//    PATCH METHOD
    @Given("Patch edit user valid body {string}")
    public void patchEditUserValidBody(String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        usersAPI.patchValidId(json);
    }
    @Given("Patch edit user with valid id {int} and body {string}")
    public void patchEditUserWithValidIdAndBody(int id, String bodyFile) {
    File json = new File(Constant.REQ_BODY+ bodyFile);
    usersAPI.patchValidId(id,json);
    }
    @When("Send request patch edit user with static id")
    public void sendRequestPatchEditUserWithStaticId() {
        SerenityRest.when()
                .patch(UsersAPI.PATCH_USER);
    }

    @When("Send request patch edit user")
    public void sendRequestPatchEditUser() {
        SerenityRest.when()
                .patch(UsersAPI.PATCH_USER_DYNAMIC);
    }

    @Given("Patch edit user with invalid id {string} and body {string}")
    public void patchEditUserWithInvalidIdAndBody(String id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        usersAPI.patchInvalidId(id,json);
    }

    @Given("Patch edit user with valid id {int} and invalid body name {string} email {string} gender {string} status {string}")
    public void patchEditUserWithValidIdAndInvalidBodyNameEmailGenderStatus(int id, String name, String email, String gender, String status) {
        usersAPI.patchValidIdWithInvalidBody(id,name,email,gender,status);
    }

    @Given("Patch edit user with invalid id {string} and invalid body name {string} email {string} gender {string} status {string}")
    public void patchEditUserWithInvalidIdAndInvalidBodyNameEmailGenderStatus(String id, String name, String email, String gender, String status) {
        usersAPI.patchInvalidIdWithInvalidBody(id,name,email,gender,status);
    }
//    DELETE METHOD


    @When("Send request Delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(UsersAPI.DELETE_USER_DYNAMIC);
    }
    @When("Send request Delete user static")
    public void sendRequestDeleteUserStatic() {
        SerenityRest.when()
                .delete(UsersAPI.DELETE_USER);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        usersAPI.deleteInvalidId(id);
    }


    @Given("Delete user with valid id")
    public void deleteUserWithValidId() {
        usersAPI.deleteValidId();
    }
}
