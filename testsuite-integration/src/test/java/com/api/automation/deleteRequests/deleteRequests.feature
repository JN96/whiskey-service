# Created by James Nicholson at 20/03/2022
Feature: DELETE Requests Test
  Test the responses of DELETE requests.

  Background: Setup the base URL
    Given url 'http://localhost:8888/whiskeyapi'
    * def token = call read('../getToken.feature')

  Scenario: Delete a whiskey
    Given path "/api/whiskeys/101"
    And headers {Accept: "application/json", Authorization: '#("Bearer " + token.response.access_token)'}
    When method DELETE # Send the DELETE request
    Then status 200 # Send the DELETE request
    * def expectedResponse = read("./data/expectedDeleteRequestResponse.json")
    And match response == expectedResponse
