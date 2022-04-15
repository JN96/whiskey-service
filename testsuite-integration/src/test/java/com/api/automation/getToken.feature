
Feature: To get the JWT token for the default user
  POST http://localhost:8887/whiskeyauth/oauth/token

  Scenario: Generate token for default user
    Given url 'http://localhost:8887/whiskeyauth/oauth/token'
    And headers {Content-Type:'multipart/form-data', Authorization: 'Basic d2hpc2tleXNlcnZpY2U6VGVzdFBhc3N3MHJk'}
    And multipart field username = 'admin'
    And multipart field password = 'TestPassw0rd'
    And multipart field scope = 'webclient'
    And multipart field grant_type = 'password'
    When method POST
    Then status 200
    * def token = response


