Feature: Registration
  AS a User
  I want a create profile API
  So that I can have access to my profile details

  Scenario: User Creates profile
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User process the create profile request
    Then User Get a 201 response

  Scenario: User is unable to create profile with password miss-match
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response

  Scenario: User is unable to create profile without password
    Given User singup with details
      | username | firstName | lastName | password | confirmPassword |
      | rafcasto | Rafael    | Castillo |          | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response

  Scenario: User is unable to create profile without Username
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      |          | Rafael    | Castillo | R4f43lC1988%% | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response

  Scenario: User is unable to create profile without password confirmation
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988%% |                 |
    When User process the create profile request
    Then User Get a 400 response

  Scenario: User is unable to create profile without Firstname
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto |           | Castillo | R4f43lC1988%% | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response

  Scenario: User is unable to create profile without Lastname
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    |          | R4f43lC1988%% | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response