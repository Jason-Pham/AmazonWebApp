@WebUI
Feature: Amazon shopping

  @Deal @AddToCart
  Scenario Outline: Amazon deal shopping
    Given User is opening Amazon home page
    And User clicks on "Today's Deals" button
    And User sort the items by "Discount - High to Low"
    Then User view the deal on the "<Item location>" item
    And User adds "<Number of items to add to cart>" items to cart
    Then User go back to home page
    Examples:
      | Item location | Number of items to add to cart |
      | 15            | 2                              |
      | 2             | 2                              |
      | 2             | 10                             |
      | 4             | 2                              |


#  @Search @AddToCart
#  Scenario: Amazon deal shopping
#    Given User is opening Amazon home page
#    And User search for "AAA Batteries"
#    And User sort the items by "Feature"
#    And User adds "5" items into the cart
#    When User go to cart
#    And User edit the "1" item quantity - set to "1"
#    And User edit the "2" item quantity - set to "3"
#    And User delete the "1" item
#    And User click "Proceed to Checkout"