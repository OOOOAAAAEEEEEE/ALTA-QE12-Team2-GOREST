Feature: Put resources test cases
  @Positive
  Scenario: Update posts with normal flows
    Given Update user with "posts/PutValidBodyValue.json"
    When Send request put posts
    Then Status code 200
    And Responses body should be "Dummy Data edit the title" as title and "lorem ipsum dolor sit amet edit the body too" as body
    And Validate JSON Schema "posts/Put/PutUpdateValidJsonSchema.json"

  Scenario Outline: Update posts with invalid body
    Given Update user with "<reqBody>"
    When Send request put posts
    Then Status code <code>
    And Responses body should be show error "<msg>"
    And Validate JSON Schema "<schema>"

    Examples:
      | reqBody                         | code | msg                     | schema                                            |
      | posts/PutWithoutBodyValue.json  | 400  | can't be blank          | posts/Put/PutUpdateWithoutOneKeyJsonSchema.json   |
      | posts/PutWithoutTitleValue.json | 400  | can't be blank          | posts/Put/PutUpdateWithoutOneKeyJsonSchema.json   |
      | posts/PutWithoutAnyValue.json   | 400  | can't be blank          | posts/Put/PutUpdateWithoutAnyValueJsonSchema.json |
      | posts/PostValidBodyValue.json   | 400  | user_id is not fillable | posts/Post/PostErrorJsonSchema.json               |

  Scenario Outline: Put update user with invalid param
    Given Update user with "/posts/PutValidBodyValue.json" as json and "<id>" as id
    When Send request put posts with invalid param
    Then Status code 404
    And Responses body should be show error "<msg>" type one
    And Validate JSON Schema "<schema>"

    Examples:
      | id       | msg                | schema                              |
      | ASDHASD  | Resource not found | posts/Post/PostErrorJsonSchema.json |
      | *@#!(@#* | Resource not found | posts/Post/PostErrorJsonSchema.json |


  Scenario: Put update user without token
    Given Update user with "/posts/PutValidBodyValue.json" without token
    When Send request put posts
    Then Status code 401
    And Responses body should be show error "Authentication failed" type one
    And Validate JSON Schema "posts/Post/PostErrorJsonSchema.json"

  Scenario Outline: Put update posts with valid body and param included in body
    Given Update user with "<reqBody>"
    When Send request put posts without id on param
    Then Status code 404
  Examples:
    | reqBody                          |
    | posts/PostValidBodyValue.json    |
    | posts/PostWithManuallyIdSet.json |