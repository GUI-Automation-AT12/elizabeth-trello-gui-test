Feature: Create Board


  Scenario: create a Board using valid credentials
    Given I log in Trello with valid Credentials
    When I navigate to BoardsPage
      And I create a board with the following information
      | name             |  Board test              |
