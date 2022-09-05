Feature: Submit Party Rock form Successfully
  Scenario: Submit form successfully
    Given  Access Form
    And  Input "playerName", "dateValue" and "testingArea" Value
    When  Click submit button
    Then Successfully tab appears
