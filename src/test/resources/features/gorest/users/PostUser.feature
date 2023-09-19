Feature: PostUser
# PositiveCase
 @Users
Scenario: Post User
    Given Post create user with "users/PostUser.json"
    When Send request Create user
    Then Status code 201
    And Has valid response with name "nayla" and email "nay@gmail.com"
    And Validate JSON schema "users/PostUserSchema.json"
