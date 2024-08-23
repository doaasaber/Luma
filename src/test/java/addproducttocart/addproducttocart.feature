Feature: Validate Adding Product To Cart

  Scenario Outline: User add product to cart
    Given navigates to what's new tab
    When add product to comparison and click on compare list
    And navigates to comparison list and add product to cart
    And navigates to cart and proceed to checkout
    And fill shipping address and payment information based on sentence from row: "<rowNumber>"
    And place order
    Then verify order created successfully
    Examples:
      | rowNumber |
      | 1         |
      | 2         |
