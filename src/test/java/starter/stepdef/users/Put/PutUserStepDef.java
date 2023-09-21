package starter.stepdef.users.Put;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.users.PostMethod.PostAPI;
import starter.gorest.users.PutMethod.PutAPI;
import starter.gorest.users.UserResponses;
import starter.utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDef {
    @Steps
    PutAPI putAPI;

    @Given("Edit user with valid id {int} and body {string}")
    public void editUserWithValidIdAndBody(int id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        putAPI.putValidId(id,json);

    }
    @When("Send request Edit user")
    public void sendRequestEditUser() {
        SerenityRest.when()
                .put(PutAPI.PUT_USER);
    }

    @And("Responses body message should be name {string} and email {string}")
    public void responsesBodyMessageShouldBeNameAndEmail(String name, String email) {
        SerenityRest.then()
                .body(UserResponses.NAME, equalTo(name))
                .body(UserResponses.EMAIL, equalTo(email));
    }
//  SCENARIO 2:Put user with invalid id
    @Given("Edit user with invalid id {string} and body {string}")
    public void editUserWithInvalidIdAndBody(String id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        putAPI.putInvalidId(id,json);
    }
//  SCENARIO 3:
    @Given("Put edit user with valid id {int} and invalid body name {string} email {string} gender {string} status {string}")
    public void putEditUserWithValidIdAndInvalidBodyNameEmailGenderStatus(int id, String name, String email, String gender, String status) {
        putAPI.putValidIdWithInvalidBody(id,name,email,gender,status);
    }
//    SCENARIO 4:
    @Given("Put edit user with invalid id {string} and invalid body name {string} email {string} gender {string} status {string}")
    public void putEditUserWithInvalidIdAndInvalidBodyNameEmailGenderStatus(String id, String name, String email, String gender, String status) {
        putAPI.putInvalidIdWithInvalidBody(id,name,email,gender,status);
    }

//    SCENARIO 3:Put user valid id with invalid body

}
