# Created by James Nicholson at 20/03/2022
Feature: GET Requests Test
  Test the responses of GET requests.

  Background: Setup the base URL
    Given url 'http://localhost:8888/whiskeyapi'
    * def token = call read('../getToken.feature')

  Scenario: Get all whiskies
    Given path "/api/whiskeys"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/expectedGetAllWhiskies.json")
    And match response == expectedResponse

  Scenario: Get whiskey by id
    Given path "/api/whiskeys/101"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/expectedWhiskeyById.json")
    And match response == expectedResponse

  Scenario: Get whiskey by category
    Given path "/api/whiskeys"
    * param category = "Irish"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/expectedWhiskeyByCategory.json")
    And match response == expectedResponse

  Scenario: Get whiskey by name
    Given path "/api/whiskeys"
    * param name = "Lagavulin"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method GET # Send the GET request
    Then status 200 # Send the GET request
    * def expectedResponse = read("./data/expectedWhiskeyByName.json")
    And match response == expectedResponse
