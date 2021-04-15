Feature: AS a User
  I want an API for CRUD actions
  So that I can have access to my profile details

  Scenario: User Creates profile
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988$$   |
    When User process the create profile request
    Then User Get a 201 response

  Scenario: User is unable to create profile on password miss-match
    Given User singup with details
      | username | firstName | lastName | password      | confirmPassword |
      | rafcasto | Rafael    | Castillo | R4f43lC1988$$ | R4f43lC1988%%   |
    When User process the create profile request
    Then User Get a 400 response