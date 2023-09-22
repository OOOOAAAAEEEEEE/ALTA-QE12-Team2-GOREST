@GOREST
Feature: Post resources "posts" test cases

  @Positive
  Scenario: Post normal flow
    Given Post create user with "posts/PostValidBodyValue.json"
    When Send request post posts
    Then Status code 201
    And Responses body should be "Dummy Title bruvvv" as title and "lorem ipsum dolor sit amet" as body
    And Validate JSON Schema "posts/Post/PostWithoutAnyErrorJsonSchema.json"

  @Negative
  Scenario Outline: Post with invalid body
    Given Post create user with "<reqBody>"
    When Send request post posts
    Then Status code <code>
    And Responses body should be show error "<msg>"
    And Validate JSON Schema "<schema>"

    Examples:
      | code | schema                                      | reqBody                           | msg            |
      | 400  | posts/Post/PostWithoutUserIdJsonSchema.json | posts/PostWithoutUserIdValue.json | must exist     |
      | 400  | posts/Post/PostWithoutOneKeyJsonSchema.json | posts/PostWithoutBodyValue.json   | can't be blank |
      | 400  | posts/Post/PostWithoutOneKeyJsonSchema.json | posts/PostWithoutTitleValue.json  | can't be blank |
      | 400  | posts/Post/PostWithoutUserIdJsonSchema.json | posts/PostWithoutAnyValue.json    | can't be blank |
      | 400  |                                             | posts/PostWithManuallyIdSet.json  |                |

  @Negative
  Scenario: Post without token
    Given post create user with "posts/PostValidBodyValue.json" and without token
    When Send request post posts
    Then Status code 401
    And Responses body should be show error "Authentication failed" type one
    And Validate JSON Schema "posts/Post/PostErrorJsonSchema.json"