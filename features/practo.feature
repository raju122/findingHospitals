Feature: Finding Hosptials
 
  Scenario: Get doctor detials and surgiers list
    Given practo website is open and working fine
    When provide location and specialisation details
    And Apply all filter options
    Then print first five doctor detials
    And click on surgiers
    And print list of surgiers
 
  Scenario: validate demo form with invalid detials
    Given practo website is open 
    When taking demo form is open and working
    And set detials for all fields
    Then check whether the submit button disabled or not
 
  Scenario: validate demo form with valid detials
    Given practo website is open and working
    When taking demo form is open
    And set detials for all fields and apply sort
    Then click on submit button
    And retrieve the thankyou message
 