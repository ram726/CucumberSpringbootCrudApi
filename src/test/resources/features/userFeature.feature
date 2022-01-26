Feature: User CRUD Operations

  Scenario: Create User object with required values
    Given : user wants to create an user record with the following attribute
      | name  | address  | phone | gender |
      | user1 | address1 | 12345 | m      |
    When user object is created saved it into database
    Then validate the saved user object

  Scenario Outline: Get a user object using user id
    When user gives an user "<id>" to search user object
    Then then validate the return object
    Examples:
        | id |
        | 1  |

  Scenario: Update the existing user object with given user id
    Given User provides an user id
        |id|
        |  1|
    When User set the new values for user object
          | name         | address         | phone | gender |
          | updatedName1 | updatedAddress1 | 09877 |        updatedGender|
    Then update the user object and persist the user

  Scenario Outline: Search and delete the user object using user id
    When user gives an user "<id>" to search user object
    Then user object is deleted from the database
    Examples:
      | id |
      | 2  |