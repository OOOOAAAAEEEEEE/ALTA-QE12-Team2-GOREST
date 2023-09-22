@GOREST
Feature: Delete user
#  SCENARIO: 1 Delete user with valid id
  Scenario: Delete user with valid id
    Given Delete user with valid id
    When Send request Delete user
    Then Status code 204


#  SCENARIO: 2 Delete user with invalid id
    Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request Delete user static
    Then Status code 404
      Examples:
        | id              |
        | nayla           |
        | 1234            |
        | &^$             |
        | nayla@gmail.com |

