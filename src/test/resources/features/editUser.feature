Feature: Edit user


  Scenario: Edit user's information in My Profile section
    Given I log in Trello with valid Credentials
    When I navigate to My Profile Page
      And I edit My Profile with the following information
        | username             |  User name UNIQUE_ID            |
        | bio                  |  Description UNIQUE_ID          |
    Then My Profile section should be updated