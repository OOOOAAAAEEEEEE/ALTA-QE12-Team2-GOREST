package starter.stepdef.users.Delete;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.gorest.users.DeleteMethod.DeleteAPI;

public class DeleteUserStepDef {
    @Step
    DeleteAPI deleteAPI;
    @Given("Delete user with valid id")
    public void deleteUserWithValidId(int id) {
        deleteAPI.deleteValidId(id);

    }

    @When("Send request Delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when()
                .delete(DeleteAPI.DELETE_USER);
    }

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidId(String id) {
        deleteAPI.deleteInvalidId(id);
    }
}
