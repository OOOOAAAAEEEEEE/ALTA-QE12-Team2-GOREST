@GOREST
Feature: Put users
#  SCENARIO 1:Put user with valid id
  @Positive
  Scenario: Put user valid id with valid body
    Given  Put edit user valid body "users/Put/PutValidId.json"
    When Send request Edit user
    Then Status code 200
    And Responses body message should be name "nay" and email "neyya@gamil.com"
    And Validate JSON Schema "users/Put/PutValidIdSchema.json"

    @Negative
#  SCENARIO 2:Put user with invalid id
    Scenario Outline:Put user invalid id with valid body
    Given  Edit user with invalid id "<id>" and body "users/Put/PutValidId.json"
    When Send request put edit user with static id
    Then Status code 404
    And Responses body message should be "Resource not found"
    And Validate JSON Schema "users/Put/PutInvalidIdSchema.json"
      Examples:
        | id       |
        | -1234    |
        | %&^*^    |
        | nasd24l2 |
        | nayyyyy  |

  @Negative
#  SCENARIO 3:Put user valid id with invalid body
  Scenario Outline:Put user valid id with invalid body
    Given Put edit user with valid id 5180162 and invalid body name "<name>" email "<email>" gender "<gender>" status "<status>"
    When Send request put edit user with static id
    Then Status code 422
    And Validate JSON Schema "users/Put/PutValidIdInvalidBodySchema.json"
    Examples:
      | name | email         | gender    | status   |
      | ney  | ney@gmail,com | female    | active   |
      | 1235 | ney@gmail.com | perempuan | inactive |
      | via  | ney@gmail.com | male      | aktif    |

    @Negative
#  SCENARIO 4:Put user  invalid id with invalid body
    Scenario Outline: Put user invalid id with invalid body
    Given Put edit user with invalid id "<id>" and invalid body name "<name>" email "<email>" gender "<gender>" status "<status>"
    When Send request put edit user with static id
    Then Status code 404
    And Responses body message should be "Resource not found"
    And Validate JSON Schema "users/Put/PutInvalidIdInvalidBodySchema.json"
      Examples:
        | id     | name |  | email         | gender    | status   |
        | -16531 | ney  |  | ney@gmail,com | female    | active   |
        | disa   | 1235 |  | ney@gmail.com | perempuan | inactive |
        | &%^%$$ | via  |  | ney@gmail.com | male      | aktif    |
