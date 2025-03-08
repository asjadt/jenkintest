Feature: Example API Test

  Scenario: Verify API response
    Given I send a GET request to "https://5e347d8d73644c7c8c69dd27d1f2a49d.api.mockbin.io/"
    Then the response status code should be 200
    Then the response body should contain "Hello World"
