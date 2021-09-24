Feature: validate Franfurt is in Germany DE
Scenario: Verify Franfurt's country, Longitude and Latitude

Given User navigates to API
When User request Get http request
Then User should be able to find the all the networks' details
And Response code should be 200
And User should be able to find the Franfurt's country and Its latitude and longitude which should be "DE" 



