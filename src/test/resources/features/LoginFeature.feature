Feature: Login
  As a User
  I want a login component
  So that I can access my profile details

  Background: User Register
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User process the create profile request
    Then User Get a 201 response

  Scenario: User can login to buggy cars website
    When User Login to Buggy cars api
    Then User receives a 200 response

  Scenario: User can not login to buggy cars website with wrong password
    Given User provides login details
      | password      |
      | R4f43lC1988%% |
    When User Login to Buggy cars api
    Then User receives a 400 response

  Scenario: User can not login to buggy cars website with wrong username
    Given User provides login details
      | username         |
      | rafcasto_invalid |
    When User Login to Buggy cars api
    Then User receives a 401 response