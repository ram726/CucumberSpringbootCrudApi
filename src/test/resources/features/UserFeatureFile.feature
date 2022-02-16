Feature: User crud operations

  Creating an user object having attribute id, name, address, phone and gender where id is auto generated

#  Background: Creating an user object where id is auto generated
#    Given user creates an user record with the following attribute
#      | name  | address  | phone  | gender |
#      | name1 | address1 | 900001 | m      |
#    When Save the user data into the database

  Scenario: Create an user object
    Given user creates an user record with the following attribute
      | name  | address  | phone  | gender |
      | name1 | address1 | 900001 | g1     |
    When Save the user data into the database
    Then Verify the saved user object

  Scenario: Create another user object
    Given user creates an user record with the following attribute
      | name  | address  | phone  | gender |
      | name2 | address2 | 900002 | g2     |
    When Save the user data into the database
    Then Verify the saved user object

#  Scenario: Find an user by phone number
#    Given user creates an user record with the following attribute
#      | name  | address  | phone  | gender |
#      | name1 | address1 | 900001 | m      |
#    When Save the user data into the database
#    And User gives a phone number to search an user object
#      | phone_number |
#      | 900001       |
#    Then validate the return object

  Scenario: Update the existing user object with phone number
    Given user creates an user record with the following attribute
      | name  | address  | phone  | gender |
      | name1 | address1 | 900001 | g1      |
    When Save the user data into the database
    And User gives a phone number to search an user object
      | phone_number |
      | 900001       |
    And User set the new values for user object
      | name         | address         | phone  | gender        |
      | updatedName1 | updatedAddress1 | 123453 | updatedGender |
    And Save the updated values of user
    Then Validate the updated user details


#  Scenario: Search and delete the user object using user phone number
#    Given user creates an user record with the following attribute
#      | name  | address  | phone  | gender |
#      | name1 | address1 | 900001 | m      |
#    When Save the user data into the database
#    And User gives a phone number to search an user object
#      | phone_number |
#      | 900001       |
#    Then user object is deleted from the database