Feature: Submit Party Rock form without input required fields

  Scenario: Submit Form Without required fields
    Given Access  URL form
    When  Do not populate required fields and click submit Button
    Then All fields show required fields

  Scenario: Submit form without Soccer Player field
    Given Access URL form
    And Imput "dateField" and "textingArea" values
    When Click Submit Button
    Then Field of Soccer Player show required field Message
