Feature: PostUser
# PositiveCase
 @Users
#   SCENARIO:Post with valid input body and valid API token
    Scenario: Post User
    Given Post create user with "users/Post/PostUser.json"
    When Send request Create user
    Then Status code 201
    And Responses body should be name "nayla" and email "nay@gmail.com"
    And Validate JSON schema "users/Post/PostUserResSchema.json"
#   SCENARIO:Post with existing email
    Scenario:


