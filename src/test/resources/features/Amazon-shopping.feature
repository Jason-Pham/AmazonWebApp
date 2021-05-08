@WebUI
Feature: Amazon shopping

  @Deal @AddToCart
  Scenario Outline: Amazon deal shopping
    Given User is opening Amazon home page
    And User clicks on "Today's Deals" button
    And User sort the deal items by "Discount - High to Low"
    And User view the deal on the "<Deal number>" item
    And User view the product on the item deal
    And User adds "<Number of items to add to cart>" items to cart
    Then User go back to home page
    Examples:
      | Deal number | Number of items to add to cart |
      | 5           | 3                              |
      | 4           | 2                              |
      | 6           | 5                              |
      | 3           | 2                              |

  @Search @AddToCart
  Scenario Outline: Search on Amazon
    Given User is opening Amazon home page
    And User search for "<searchText>"
    And User sort the search items by "<sortType>"
    And User view the product on the "<searchItemNumber>" item search
    And User adds "<numberOfProduct>" items to cart
    Then User go back to home page
    And User search for "<searchText>"
    And User view the product on the "<searchItemNumber1>" item search
    And User adds "<numberOfProduct1>" items to cart
    When User go to cart
    And User edit the "<numberOfItem>" item quantity - set to "<quantity>"
    And User edit the "<numberOfItem1>" item quantity - set to "<quantity1>"
    And User delete the "<cartItemNumber>" item
    Then User click "<checkoutStep>"
    Examples:
      | searchText    | sortType | searchItemNumber | numberOfProduct | searchItemNumber1 | numberOfProduct1 | numberOfItem | quantity | numberOfItem1 | quantity1 | cartItemNumber | checkoutStep        |
      | AAA Batteries | Featured | 7                | 1               | 1                 | 2                | 1            | 1        | 2             | 3         | 1              | Proceed to Checkout |