package steps;

import customs.SessionContext;
import dto.BaseResponse;
import dto.UserRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;
import repositories.UserRepository;

import java.util.*;

public class UserProfileSteps implements En {
    private UserRequest userRequest;
    private UserRepository userRepository;
    private BaseResponse actualResponse;
    private SessionContext sessionContext;

    public UserProfileSteps( SessionContext sessionContext,BaseResponse actualResponse) {
        this.sessionContext = sessionContext;
        this.userRequest = sessionContext.userRequest;
        this.userRepository = sessionContext.userRepository;
        this.actualResponse = actualResponse;
    }

    @Given("User singup with details")
    public void userSingupWithDetails(List<UserRequest> userRequestTable) {

        this.userRequest = userRequestTable.stream().findFirst().orElse(null);
        this.sessionContext.userRequest = this.userRequest;
    }

    @When("User process the create profile request")
    public void userProcessTheCreateProfileRequest() {

        actualResponse = userRepository.createUser(this.userRequest);
    }

    @Then("User Get a {int} response")
    public void userGetAResponse(int expectedStatusResponseCode) {
        Assert.assertEquals("Response status:", expectedStatusResponseCode, actualResponse.getStatus());
    }
}
