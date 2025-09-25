Feature: Check response when send request successfully
Scenario: Check response when send request successfully
Given I have valid cats URL and method
When I send a cats request
Then I get a cats status code and response