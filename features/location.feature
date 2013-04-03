Feature: Login feature

@wip
  Scenario: Navigate to Location page
    Given I see "Hello bitemoi!"
    When I press "Location"
    Then I see "Location"
    
    When I go back
    Given I see "Hello bitemoi!"
