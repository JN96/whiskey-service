# Created by James Nicholson at 20/03/2022
Feature: Data Cleanup
  Resets the data after each each suites is ran.

  Background: Setup the base URL
    Given url 'http://localhost:8080'

  Scenario: Reset default data
    Given path "/api/whiskies"
    And header Accept = "application/json"
    And header Content-Type = "application/json"
    When method POST # Send the POST request
    Then status 200 # Send the POST request
    * def expectedResponse = read("./data/defaultData.json")
#    And match response == expectedResponse

