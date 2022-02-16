Feature: User Get and Delete Operation

  Scenario: Find an user by phone number
    Given user creates an user record with the following attribute
      | name  | address  | phone  | gender |
      | name1 | address1 | 900001 | g1     |
    When Save the user data into the database
    And User gives a phone number to search an user object
      | phone_number |
      | 900001       |
    Then validate the return object

  Scenario: Search and delete the user object using user phone number
    Given user creates an user record with the following attribute
      | name  | address  | phone  | gender |
      | name1 | address1 | 900001 | g1      |
    When Save the user data into the database
    And User gives a phone number to search an user object
      | phone_number |
      | 900001       |
    Then user object is deleted from the database