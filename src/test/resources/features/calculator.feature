Feature: Sample Calculator Functions

  Background:
    Given User provides first number
      | first_number |
      | 2            |
    And User provides second number
      | second_number |
      | 3             |

  @anyTagName1
  Scenario: Addition of two number
    When Adding these two number
    Then Verify the addition result

  Scenario: Subtraction of two number
    When Subtracting these two number
    Then Verify the subtract result

  @anyTagName2
  Scenario: Multiplication of two number
    When Multiply these two number
    Then Verify the multiplied result

  Scenario: Division of two number
    When Divide these two number
    Then Verify the divide result