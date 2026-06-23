Feature: Identify New Bikes

  Scenario: New Bikes
    Given Open "Chrome" browser and zigwheels website
    Then Go to new Bikes
    Then Click on Upcoming bikes
    Then Go to Manufacture and Click on Honda
    Then Get all the bikes below 4 Lakh

  Scenario: Used Cars
    Given Go to Used cars and click Chennai
    Then Go to Popular model
    Then Get all Popular cars

  Scenario: Login
    Given Click on login
    Then click google
    Then Type any email id
