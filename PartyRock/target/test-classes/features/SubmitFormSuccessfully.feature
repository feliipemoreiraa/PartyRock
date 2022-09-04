Feature: Submit Party Rock form Successfully
  Scenario: Submit the form successfully
    Given  Access URL form
    And  Input "playerName", "dateValue" and "testingArea" Values
    When  Click Submit Button
    Then Successfully Tab Appears