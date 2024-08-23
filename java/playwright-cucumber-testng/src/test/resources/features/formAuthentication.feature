Feature: Login Page

  Scenario: Successful login with valid credentials
    Given I am on the form authentication page
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to the secure area

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the form authentication page
    When I enter invalid credentials
    And I click the login button
    Then I should see an error message
