Feature: Example UI Test

  Scenario: Verify page title
    Given I open the browser and navigate to "https://www.google.com"
    Then the page title should be "Google"
