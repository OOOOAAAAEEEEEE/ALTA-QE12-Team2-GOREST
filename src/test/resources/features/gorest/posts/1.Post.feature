Feature: Posts resources test cases
  @Positive
  Scenario Outline: Post normal flow
    Given Post create user with "<reqBody>"
    When Send request post posts
    Then Status code <code>
    And Responses body should be "<title>" as title and "<body>" as body
    And Validate JSON Schema "<schema>"

    Examples:
      | code | schema                                        | reqBody                       | title              | body                       |
      | 201  | posts/Post/PostWithoutAnyErrorJsonSchema.json | posts/PostValidBodyValue.json | Dummy Title bruvvv | lorem ipsum dolor sit amet |

  Scenario Outline: Post with invalid body
    Given Post create user with "<reqBody>"
    When Send request post posts
    Then Status code <code>
    And Responses body should be show error "<msg>"
    And Validate JSON Schema "<schema>"

    Examples:
      | code | schema                                      | reqBody                           | msg            |
      | 400  | posts/post/PostWithoutUserId.json           | posts/PostWithoutUserIdValue.json | must exist     |
      | 400  | posts/post/PostWithoutOneKeyJsonSchema.json | posts/PostWithoutBodyValue.json   | can't be blank |
      | 400  | posts/post/PostWithoutOneKeyJsonSchema.json | posts/PostWithoutTitleValue.json  | can't be blank |
      | 400  | posts/post/PostWithoutUserIdJsonSchema.json | posts/PostWithoutAnyValue.json    | can't be blank |
      | 400  |                                             | posts/PostWithManuallyIdSet.json  |                |


  Scenario: Post without token
    Given post create user with "posts/PostValidBodyValue.json" and without token
    When Send request post posts
    Then Status code 401
    And Responses body should be show error "Authentication failed" type one
    And Validate JSON Schema "posts/Post/PostErrorJsonSchema.json"