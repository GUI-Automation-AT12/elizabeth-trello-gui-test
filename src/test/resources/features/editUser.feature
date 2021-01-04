@UserProfile
Feature: Edit user

  Background:
    Given I log in Trello with Editable user credentials

  @functional @resetUserInformation
  Scenario: Edit user's information in My Profile section
    When I navigate to My Profile Page
      And I edit My Profile with the following information
        | username | new user name UNIQUE_ID |
        | bio      | Description UNIQUE_ID   |
    Then "Saved" message should be displayed in My Profile and Visibility section
      And the user information should be updated in My Profile and Visibility section