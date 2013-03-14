Feature: Search for a restaurant based on food
@yas
	Scenario: Search for a restaurant
		    Given I see "Hello bitemoi!"
		    When I press "Search"
		    Then I should be in the "Food Search" page
    
    		When I go back
    		Given I see "Hello bitemoi!"
