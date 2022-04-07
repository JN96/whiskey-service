# Created by James Nicholson at 20/03/2022
Feature: DELETE Requests Test
  Test the responses of DELETE requests.

  Background: Setup the base URL
    Given url 'http://localhost:8888/whiskeyapi'

  Scenario: Delete a whiskey
    Given path "/api/whiskeys/101"
    And header Accept = "application/json"
    When method DELETE # Send the DELETE request
    Then status 200 # Send the DELETE request
    * def expectedResponse = read("./data/expectedDeleteRequestResponse.json")
    And match response == expectedResponse
