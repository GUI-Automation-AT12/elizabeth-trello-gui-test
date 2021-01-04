@Board
Feature: Create Board

  In order to create a board
  As a valid user

  Background:
    Given I log in Trello with Valid user credentials

  Scenario: create a Board using valid credentials
    Given I log in Trello with valid Credentials
    When I navigate to BoardsPage
      And I create a board with the following information
      | name             |  Board test              |
