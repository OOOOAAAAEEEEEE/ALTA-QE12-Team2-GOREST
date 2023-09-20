Feature: Post Resources endpoint

  Scenario Outline: Post method with valid body
    Given Base URL and "<path>" as path and "<pathParam>" as pathParam and "<queryParam>" as queryParam
    And Passing "<jsonPath>" as json request into body and set contentType as Json
    When Send request Post method
    Then Status code should be 201
    And Responses body should be "randomize" as title and "lorem ipsum generator brow waduh hahahaha jiah" as body
    And Validate JSON schema "<jsonSchema>"
    Examples:
      | path             | pathParam | queryParam | jsonPath              | jsonSchema                          |
      | /public/v2/posts |           |            | posts/PostMethod.json | posts/Post/PostWithoutAnyError.json |