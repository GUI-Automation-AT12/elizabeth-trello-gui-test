@LoginUser
Feature: Login
  @Functional
  Scenario: Login with valid credentials
    Given I am on the Login page
    When  I set username and password
    Then  I should view the "boards" suffix in the URL