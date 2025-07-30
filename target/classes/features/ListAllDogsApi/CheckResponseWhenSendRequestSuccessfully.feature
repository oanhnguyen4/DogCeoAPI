@ListAllDogApi
Feature:Test list all dogs api
      @HappyCase
      Scenario:Check response when send request successfully
          Given I have a request with URL and Method
          When I send the request
          Then Api will responds status code and response body