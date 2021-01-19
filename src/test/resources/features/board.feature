@Board
Feature: Board

  Background:
    Given I log in Trello with Valid user credentials

  @Functional @DeleteBoard
  Scenario: Create a Board with the minimum information required
    When I navigate to Boards Page
    And I create a board with the following information
      | name | new board UNIQUE_ID |
    Then The board name should be displayed on Board Page

  @Functional @DeleteBoard
  Scenario: Create a Board
    When I navigate to Boards Page
      And I create a board with the following information
        | name    | new board UNIQUE_ID |
        | team    | My team             |
        | privacy | Private             |
    Then The board name should be displayed on Board Page
      And The board team name should be displayed on Board Page
      And The board privacy should be displayed on Board Page

  @Skipped @Functional @CreateBoard
  Scenario: Delete a Board
    When I navigate to Boards Page
    And I select specific board
    And I delete the board
    Then "Board not found." message should be displayed on Board Page
