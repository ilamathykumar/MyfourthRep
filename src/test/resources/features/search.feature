Feature: Amazon Search

Scenario: Search a Product
          Given I have a search field for Amazon Page
          When I search for a product with name "Apple MacBook Pro" with price 1000
          Then Product with name "Apple MacBook Pro" should be dispalyed
          Then Order id is 12345 
          