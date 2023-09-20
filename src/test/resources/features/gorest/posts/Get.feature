Feature: Get method endpoint

  Scenario Outline: Get list all of posts
    Given Base URL and "<path>" as path and "<pathParam>" as pathParam and "<queryParam>" as queryParam
    When Send request get method list all of posts
    Then Status code should be 200
    And Validate JSON schema "<jsonSchema>"
    Examples:
      | path                           | pathParam | queryParam         | jsonPath | jsonSchema                                  |
      | /public/v2/posts               |           |                    |          | posts/Get/GetListAllOfPostsJsonSchema.json  |
      | /public/v2/users/5180432/posts |           |                    |          | posts/Get/GetSingleUserPostsJsonSchema.json |
      | /public/v2/posts               |           | ?per_page=1&page=1 |          | posts/Get/GetSingleUserPostsJsonSchema.json |