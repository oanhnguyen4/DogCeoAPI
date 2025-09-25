Feature: Check response when send request successfully
Scenario: Check response when send request successfully
Given I have valid dogs URL and method
|URL|Method|
|https://dog.ceo/api/breeds/list/all|GET|
When I send a dogs request
Then I get a dogs status code and response