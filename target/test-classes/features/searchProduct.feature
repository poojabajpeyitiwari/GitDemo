Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both Home and Offers Page

Given User is on GreenKart landing page
When User Searched with shortname <Name> and extracted the actual name of product
Then User Searched for <Name> shortname in offers page
And Validate product name in offers page matches with Landing Page

Examples:
|Name|
|Tom|
|Beet|