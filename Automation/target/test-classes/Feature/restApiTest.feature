Feature: API Testing using Cucumber and REST Assured

  @instance_1
  Scenario: Validate the GET endpoint
    Given the base URL is "http://localhost:3000/"
    When I make a GET request to "/users/"
    Then the response status code should be 200
    And the response should contain "age" with value 30
    And the response should contain "id" with value 1

  @instance_2
  Scenario: Valdiate the GET endpoint
    Given the base URL is "http://localhost:3000/"
    When I make a GET request to "/users/"
    Then the response status code should be 200
    And the response should contain "Mike Smith" and "mike@example.com"
    And the response should contain "id" with value 3

  @instance_3
  Scenario: Validiate the POST request
  	Given the API endpoint is "http://localhost:3000/users"
  	Then create a post request using below data
  	|name|Bikramaditya|
  	|email|bikramaditya@gmail.com|
  	
  @instance_4
  Scenario: Validate the PUT request
  	Given the API endpoint is "http://localhost:3000/users"
  	When I send a PUT request with the following data
  	|name|Bikramaditya2|
  	|email|bikramaditya@gmail2.com|
  	Then the response status code should be 201
  	And response should contain
  	|name|Bikramaditya2|
  	|email|bikramaditya@gmail2.com|
  	
  @instance_5
  Scenario: Validate the DELETE request
  	Given the API endpoint is "https://reqres.in/api/users/2"
  	When I send a Delete Request
  	Then the response status code should be 204