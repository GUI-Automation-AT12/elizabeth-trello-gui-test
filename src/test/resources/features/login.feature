Feature: Login

  Scenario: Login with valid credentials
    Given I am on the login page "https://trello.com/login"
    When  I set username and password
    Then  I should view the "boards" suffix in the URL