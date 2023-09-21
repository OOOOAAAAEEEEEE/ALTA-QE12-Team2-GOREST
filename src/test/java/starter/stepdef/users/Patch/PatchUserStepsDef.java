package starter.stepdef.users.Patch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.users.PatchMethod.PatchAPI;
import starter.utils.Constant;

import java.io.File;

public class PatchUserStepsDef {
    @Steps
    PatchAPI patchAPI;
    @Given("Patch edit user with valid id {int} and body {string}")
    public void patchEditUserWithValidIdAndBody(int id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        patchAPI.patchValidId(id,json);
    }

    @When("Send request patch edit user")
    public void sendRequestPatchEditUser() {
            SerenityRest.when()
                    .patch(PatchAPI.PATCH_USER);
    }

    @Given("Patch edit user with invalid id {string} and body {string}")
    public void patchEditUserWithInvalidIdAndBody(String id, String bodyFile) {
        File json = new File(Constant.REQ_BODY+ bodyFile);
        patchAPI.patchInvalidId(id,json);
    }

    @Given("Patch edit user with valid id {int} and invalid body name {string} email {string} gender {string} status {string}")
    public void patchEditUserWithValidIdAndInvalidBodyNameEmailGenderStatus(int id, String name, String email, String gender, String status) {
        patchAPI.patchValidIdWithInvalidBody(id,name,email,gender,status);
    }

    @Given("Patch edit user with invalid id {string} and invalid body name {string} email {string} gender {string} status {string}")
    public void patchEditUserWithInvalidIdAndInvalidBodyNameEmailGenderStatus(String id, String name, String email, String gender, String status) {
        patchAPI.patchInvalidIdWithInvalidBody(id,name,email,gender,status);
    }
}
