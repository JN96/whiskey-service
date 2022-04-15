# Created by James Nicholson at 21/03/2022
Feature: POST Requests Test
  Test the functionality of POST requests

  Background: Setup the base URL
    Given url 'http://localhost:8888/whiskeyapi'
    * def token = call read('../getToken.feature')

  Scenario: Create a new whiskey
    Given path "/api/whiskeys"
    And headers {Content-Type: 'application/json', Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    * def body = read("./data/createWhiskeyRequestBody.json")
    And request body
    When method POST # Send the POST request
    Then status 201 # Send the POST request
    * def expectedResponse = read("./data/expectedCreateWhiskeyResponse.json")
    And match response == expectedResponse

  Scenario: Get whiskey by name
    Given path "/api/whiskeys"
    * param name = "Connemara"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/expectedGetWhiskeyByNameResponse.json")
    And match response == expectedResponse
