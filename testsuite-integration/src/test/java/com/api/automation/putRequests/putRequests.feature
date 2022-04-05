# Created by James Nicholson at 21/03/2022
Feature: PUT Requests Test
  Test the functionality of PUT requests

  Background: Setup the base URL
    Given url 'http://localhost:8888/whiskeyapi'

  Scenario: Update whiskey by Id
    Given path "/api/whiskeys/4"
    And header Accept = "application/json"
    And header Content-Type = "application/json"
    * def body = read("./data/updateByIdRequestBody.json")
    And request body
    When method PUT # Send the PUT request
    Then status 201 # Send the PUT request
    * def expectedResponse = read("./data/expectedUpdateWhiskeyById.json")
    And match response == expectedResponse

  Scenario: Check whiskey has been updated correctly
    Given path "/api/whiskeys/4"
    And header Accept = "application/json"
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/updateByIdRequestBody.json")
    And match response == expectedResponse
