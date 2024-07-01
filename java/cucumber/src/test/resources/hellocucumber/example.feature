Feature: An example

  Scenario Outline: Search for terms on Google
    Given the user is on the Google search page
    When the user searches for "<search_term>"
    Then the search results page should contain "<expected_result>"

    @chrome
    Examples: Chrome Searches
      | search_term | expected_result                  |
      | Cucumber    | BDD Testing                      |
      | Selenium    | Selenium WebDriver               |

    @edge
    Examples: Edge Searches
      | search_term | expected_result                  |
      | Cucumber    | BDD Testing                      |
      | Selenium    | Selenium WebDriver               |
