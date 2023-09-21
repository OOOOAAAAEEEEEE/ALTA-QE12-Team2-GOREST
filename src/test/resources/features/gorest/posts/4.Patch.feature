@GOREST
Feature: Patch resources test cases
  @Positive
  Scenario Outline: Update posts with normal flows
    Given Update user with "<reqBody>"
    When Send request patch posts
    Then Status code <code>
    And Responses body should be "<title>" as title and "<body>" as body
    And Validate JSON Schema "<schema>"

    Examples:
      | reqBody                         | code | title                           | body                                             | schema                                  |
      | posts/PutValidBodyValue.json    | 200  | Dummy Data edit the title       | lorem ipsum dolor sit amet edit the body too     | posts/Put/PutUpdateValidJsonSchema.json |
      | posts/PutWithoutBodyValue.json  | 200  | Dummy Data without editing body | lorem ipsum dolor sit amet edit the body too     | posts/Put/PutUpdateValidJsonSchema.json |
      | posts/PutWithoutTitleValue.json | 200  | Dummy Data without editing body | lorem ipsum dolor sit amet without editing title | posts/Put/PutUpdateValidJsonSchema.json |

  @Negative
  Scenario Outline: Update posts with invalid body
    Given Update user with "<reqBody>"
    When Send request patch posts
    Then Status code <code>
    And Responses body should be show error "<msg>"
    And Validate JSON Schema "<schema>"

    Examples:
      | reqBody                       | code | msg             | schema                                            |
      | posts/PutWithoutAnyValue.json | 204  | No updated data | posts/Put/PutUpdateWithoutAnyValueJsonSchema.json |

  @Negative
  Scenario Outline: Patch update user with invalid param
    Given Update user with "/posts/PutValidBodyValue.json" as json and "<id>" as id
    When Send request patch posts with invalid param
    Then Status code 404
    And Responses body should be show error "<msg>" type one
    And Validate JSON Schema "<schema>"

    Examples:
      | id       | msg                | schema                              |
      | ASDHASD  | Resource not found | posts/Post/PostErrorJsonSchema.json |
      | *@#!(@#* | Resource not found | posts/Post/PostErrorJsonSchema.json |

  @Negative
  Scenario: Patch update user without token
    Given Update user with "/posts/PutValidBodyValue.json" without token
    When Send request patch posts
    Then Status code 401
    And Responses body should be show error "Authentication failed" type one
    And Validate JSON Schema "posts/Post/PostErrorJsonSchema.json"

  @Negative
  Scenario Outline: Patch update posts with valid body and param included in body
    Given Update user with "<reqBody>"
    When Send request patch posts without id on param
    Then Status code 404
  Examples:
    | reqBody                           |
    | posts/PostValidBodyValue.json     |
    | posts/PostWithManuallyIdSet.json  |
    | posts/PutWithoutUsersIdValue.json |