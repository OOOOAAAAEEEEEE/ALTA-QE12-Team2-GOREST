Feature: PostUser

#   SCENARIO 1:Post with valid input body and valid API token
    Scenario: Post User
    Given Post create user with "users/Post/PostUser.json"
    When Send request Create user
    Then Status code 201
    And Responses body should be name "nayla" and email "neya@gmail.com"
    And Validate JSON Schema "users/Post/PostUserResSchema.json"
#   SCENARIO 2:Post with existing email
    Scenario:Post with existing email
       Given Post create user with "users/Post/PostExistingEmail.json"
       When Send request Create user
       Then Status code 422
       And Validate JSON Schema "users/Post/PostExistingEmailSchema.json"

#   SCENARIO 3: Post without body
    Scenario:Post without body
    Given Post create user with "users/Post/PostWithoutBody.json"
    When Send request Create user
    Then Status code 422
    And Validate JSON Schema "users/Post/PostWithoutBodySchema.json"

#   SCENARIO 4: Post with invalid body
    Scenario Outline: Post with invalid body
    Given Post create user with name "<name>" email "<email>" gender "<gender>" status "<status>"
    When Send request Create user
    Then Status code 422
    And Validate JSON Schema "users/Post/PostInvalidBodySchema.json"
    Examples:
      | name | email         | gender    | status   |
      | ney  | ney@gmail,com | female    | active   |
      | 1235 | ney@gmail.com | perempuan | inactive |
      | via  | ney@gmail.com | male      | aktif    |

#    SCENARIO 5:Post with invalid email
    Scenario: Post with invalid email
      Given Post create user with "users/Post/PostInvalidEmail.json"
      When Send request Create user
      Then Status code 422
      And Validate JSON Schema "users/Post/PostInvalidEmailSchema.json"

#    SCENARIO 6:Post without Authorization token
      Scenario: Post without authorization token
      Given Post create user without authorization token with "users/Post/PostWithoutAutorizationToke.json"
      Then Send request Create user
      Then Status code 401
      And Responses body message should be "Authentication failed"
      And Validate JSON Schema "users/Post/PostWithoutAutorizationTokenSchema.json"


