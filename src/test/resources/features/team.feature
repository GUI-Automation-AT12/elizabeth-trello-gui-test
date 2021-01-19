@Team
Feature: Team

  Background:
    Given I log in Trello with Valid user credentials

  @Functional @DeleteTeam
  Scenario: Create a Team with the minimum information required
    When I navigate to Home Page
    And I create a team with the following information
      | name        | team UNIQUE_ID   |
      | type        | Education        |
      | description | description team |
    Then The team name should be displayed on Team Page

  @Skipped @Functional @CreateTeam @DeleteTeam
  Scenario: Edit Team information on Team Page
    When I select a specific team
    And I edit the Team information with the following information
      | name        | newTeam UNIQUE_ID |
      | type        | Marketing         |
      | shortName   | newTeam UNIQUE_ID |
      | description | description       |
    Then The team name should be updated on Team Page
