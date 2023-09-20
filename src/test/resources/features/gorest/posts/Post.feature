Feature: Posts resources test cases

  Scenario Outline: Post normal flow
    Given Post create user with "<reqBody>"
    When Send request post posts
    Then Status code <code>
    And Responses body should be "<title>" as title and "<body>" as body
    And Validate JSON Schema "<schema>"

    Examples:
      | code | schema                              | reqBody                     | title              | body                       |
      | 201  | posts/post/PostWithoutAnyError.json | posts/PostValidReqBody.json | Dummy Title bruvvv | lorem ipsum dolor sit amet |

  Scenario Outline: Post with invalid body
    Given Post create user with "<reqBody>"
    When Send request post posts
    Then Status code <code>
    And Responses body should be show error "<msg>"
    And Validate JSON Schema "<schema>"

    Examples:
      | code | schema                                  | reqBody                             | msg            |
      | 400  | posts/post/PostWithoutUserId.json       | posts/PostWithoutUserIdReqBody.json | must exist     |
      | 400  | posts/post/PostWithoutOneKeySchema.json | posts/PostWithoutBody.json          | can't be blank |
      | 400  | posts/post/PostWithoutOneKeySchema.json | posts/PostWithoutTitle.json         | can't be blank |
      | 400  | posts/post/PostWithoutUserId.json       | posts/PostWithoutAnyValue.json      | can't be blank |
      | 400  |                                         | posts/PostWithManuallyIdSet.json    |                |


    #ERROR GK JELAS
  Scenario: Post without token
    Given post create user with "posts/PostWithoutAnyError.json" and without token
    When Send request post posts
    Then Status code 401
    And Responses body should be show error "Authentication Failed"
    And Validate JSON Schema "posts/Post/PostError.json"