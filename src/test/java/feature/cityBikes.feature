Feature: Validate City Bikes location
  
 Scenario: As a user I want to see and verify City Bikes location
    Given User navigates to API
		When User request Get http request
	 	Then Response code should be 200
	 	Then User should be able to find the all the networks' details
    And User should be able to find the location of City bikes
  

 