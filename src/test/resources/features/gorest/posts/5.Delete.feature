Feature: Delete resources test cases
  @Positive
  Scenario: Delete single valid posts
    Given Delete single posts
    When Send request delete posts
    Then Status code 204

  Scenario Outline: Delete single with invalid param
    Given Delete single posts "<id>" as invalid param
    When Send request delete posts with invalid param
    Then Status code 404

    Examples:
      | id       |
      | 3719238  |
      | alskdhsl |
      | *@^#*@#  |