@regressionEO3
Feature: product reviews

  @TC006EO
  Scenario: Product review after purchasing a product
    When User is in the demo shop page
    Then I click register
    And User registers
    Then I click "Books" in the menu
    Then I select "Fiction" in "" subcategory
    And I input quantity: "1"
    And  I click add to cart
    And I turn off the notification
    Then I click shopping cart
    And I should see "1" "Fiction" in the cart
    Then I click agree to terms
    And I click checkout
    Then I input billing address fields
    And I click continue for all forms
    Then I click confirm
    Then I click on click here for order details
    And I click on "Fiction"
    Then I click on review
    And I write a review with "Review title" and "This is a good product"
    Then I submit a review
    And I verify the success message

  @B001EO
  Scenario: Product review without purchasing a product
    When User is in the demo shop page
    Then I click register
    And User registers
    Then I click "Books" in the menu
    Then I select "Fiction" in "" subcategory
    Then I click on review
    And I write a review with "Review title" and "This is a good product"
    Then I submit a review
    And I verify the success message

  @TC007EO
  Scenario: Product review without user being logged in
    When User is in the demo shop page
    Then I click "Books" in the menu
    Then I select "Fiction" in "" subcategory
    Then I click on review
    Then I check the review box message
    And I check review title and message input fields are blocked
