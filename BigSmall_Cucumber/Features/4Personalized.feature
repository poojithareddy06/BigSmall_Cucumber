Feature: Personalized Gifts
Scenario Outline: Customize name
Given The home page is open
When I click on Personalized gifts
Then Navigate to the page and select product
And Customize the "<name>" to be printed


Examples:
|name|
|Poojitha|
