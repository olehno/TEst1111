@regressionEO2
Feature: User is able to add product to compare list

  @TC002EO
  Scenario: User adds one product to compare list
    When User is in the demo shop page
    Then I click "Books" in the menu
    Then I select "Fiction" in "" subcategory
    And I click add to compare list
    And I check if "Fiction" is in the compare list

  @TC003EO
  Scenario: User adds two products to compare list
    When User is in the demo shop page
    Then I click "Books" in the menu
    Then I select "Fiction" in "" subcategory
    And I click add to compare list
    And I check if "Fiction" is in the compare list
    Then I click "Computers" in the menu
    Then I select "14.1-inch Laptop" in "Notebooks" subcategory
    And I click add to compare list
    And I check if "Fiction" is in the compare list
    And I check if "14.1-inch Laptop" is in the compare list