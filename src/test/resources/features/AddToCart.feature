@regressionEO1
Feature: A user is able to add a product to a shopping cart

  @TC001EO-01
  Scenario Outline: A user adds a product to a shopping cart
    When User is in the demo shop page
    Then I click "<product_type>" in the menu
    Then I select "<product>" in "<subcategory>" subcategory
    And I input quantity: "<quantity>"
    And  I click add to cart
    And I turn off the notification
    Then I click shopping cart
    And I should see "<quantity>" "<product>" in the cart
    Examples:
      | product_type | product          | quantity | subcategory |
      | Books        | Fiction          | 1        |             |
      | Computers    | 14.1-inch Laptop | 2        | Notebooks   |

  @TC004EO
  Scenario: A user adds a product with additional options to a shopping cart
    When User is in the demo shop page
    Then I click "Jewelry" in the menu
    Then I select "Create Your Own Jewelry" in "" subcategory
    And I input quantity: "1"
    Then I select product options:
      | material | Silver (1 mm) |
      | length   | 20            |
    And I click add to cart
    And I turn off the notification
    Then I click shopping cart
    And I should see "1" "Create Your Own Jewelry" in the cart

  @TC005EO
  Scenario: A user fails to add a product without declaring mandatory additional options to a shopping cart
    When User is in the demo shop page
    Then I click "Jewelry" in the menu
    Then I select "Create Your Own Jewelry" in "" subcategory
    And I input quantity: "1"
    And I click add to cart
    And I turn off the notification
    Then I click shopping cart
    And I should see empty shopping cart

