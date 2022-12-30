
Feature: Login Function

  Background:
    Given User is on the Landing page

  Scenario: Successful Login
    Given User is on the Landing page and click login page
    And User add username
    And User add password
    When User Login tapp
    Then Login successful message is displayed
