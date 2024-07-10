Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search the product and Add to Cart and Verify product details in checkout page

Given User is on GreenKart landing page
When User Searched with shortname <Name> and extracted the actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
|Name|
|Tom |
