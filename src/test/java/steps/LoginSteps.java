package steps;

import customs.SessionContext;
import dto.BaseResponse;
import dto.TokenResponse;
import dto.UserRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.junit.Assert;

import java.util.List;

public class LoginSteps implements En {
    TokenResponse tokenResponse;
    BaseResponse actualResponse;
    private SessionContext sessionContext;

    public LoginSteps(SessionContext sessionContext,BaseResponse actualResponse)
    {
        this.sessionContext = sessionContext;
        this.actualResponse = actualResponse;
    }

    @When("User Login to Buggy cars api")
    public void userLoginToBuggyCarsApi() {
       tokenResponse =  sessionContext.userRepository.userLogin(sessionContext.userRequest);
       this.actualResponse = tokenResponse;
    }

    @Then("User is able to create session token")
    public void userIsAbleToCreateSessionToken() {

    }

    @Then("User receives a {int} response")
    public void userReceivesAResponse(int expectedResponseStatus)
    {
        Assert.assertEquals("Response status:", expectedResponseStatus, actualResponse.getStatus());
    }

    @When("User provides login details")
    public void userLoginToBuggyCarsApiWith(List<UserRequest> userRequests)
    {
        setNewUserRequest(userRequests.stream().findFirst().orElse(null));
    }

    private void setNewUserRequest(UserRequest user)
    {
        if(user.getUsername() != null && !user.getUsername().isEmpty())
        {
            sessionContext.userRequest.setUsername(user.getUsername());
        }
        if(user.getPassword() != null && !user.getPassword().isEmpty())
        {
            sessionContext.userRequest.setPassword(user.getPassword());
        }
    }
}
