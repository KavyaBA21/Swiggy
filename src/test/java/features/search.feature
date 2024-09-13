Feature: Search Product Functionality
  Scenario: Search the briyani product
    Given User launch the browser as "Chrome"
    And User launch the url
    When User click on the search button
    And User enter product in search box "biryani"
    Then User verifies that shop with high ratings