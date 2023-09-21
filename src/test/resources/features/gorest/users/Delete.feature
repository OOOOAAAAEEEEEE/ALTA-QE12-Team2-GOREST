Feature: Delete user
#  SCENARIO: 1 Delete user with valid id
  Scenario: Delete user with valid id
    Given Delete user with valid id
    When Send request Delete user
    Then Status code 200
    And Validate JSON Schema "users/Delete/DeleteValidIdSchema.json"
#  SCENARIO: 2 Delete user with invalid id
    Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request Delete user
    Then Status code 404
    And Responses body message should be ""
    And Validate JSON Schema "users/Delete/DeleteInvalidIdSchema.json"
      Examples:
        | id              |
        | nayla           |
        | -1234           |
        | %&^$            |
        | nayla@gmail.com |

