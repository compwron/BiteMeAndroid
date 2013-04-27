Feature: Search for a restaurant based on food

	Scenario: Search for a restaurant
	    Given I see "Hello bitemoi!"
	    When I press "Search"
	    Then I should be in the "Food Search" page
	    
	    When I clear input field with id "search"
	    Then I enter text "sushi" into field with id "search"
	    And I press the "GO" button
	    Then I should not see "results..."
	
		When I go back
		Then I should see "Hello bitemoi!"
