@GOREST
Feature: Get resources "users" test cases

  @Positive
#  SCENARIO 1:Get all user
  Scenario: Get all user
  Given Get list user
  When Send request Get list user
  Then Status code 200
  And Validate JSON Schema "users/Get/GetAllUserSchema.json"

  @Positive
#  SCENARIO 2: Get user detail with valid id
  Scenario: Get user detail with valid id
    Given Get user with valid id 5186727
    When Send request Get detail user
    Then Status code 200
    And Validate JSON Schema "users/Get/GetUserWithValidId.json"

  @Negative
#  SCENARIO 3: Get user detail with invalid id
  Scenario Outline: Get user detail with invalid id
    Given Get detail user invalid id "<id>"
    When Send request Get detail user
    Then Status code 404
    And Validate JSON Schema "users/Get/GetWithInvalidIdSchema.json"
    Examples:
      | id          |
      | ^^$^&*      |
      | nayla       |
      | naygmailcom |
      | -4362       |

  @Positive
#     SCENARIO 4:Get all user with valid query param
    Scenario: Get all user with valid query param
    Given Get list user valid query param page <1> per page <3>
    When Send request Get list user with param
    Then Status code 200
    And Validate JSON Schema "users/Get/GetAllUserValidQueryParamSchema.json"

    @Negative
#     SCENARIO 5:Get all user with invalid query param
    Scenario Outline: Get all user with invalid query param
    Given Get list user invalid query param page "<page>" per page "<per page>"
    When Send request Get list user with param
    Then Status code 400
    And Validate JSON Schema "users/Get/GetAllUserInvalidQueryParamSchema.json"
      Examples:
        | page | per page |
        | 1    | lima     |
        | dua  | satu     |
        | lima | empat    |
        | $&^$ | ^*&      |
        | 1    |          |
        |      | 9        |
        | -6   | -3       |
