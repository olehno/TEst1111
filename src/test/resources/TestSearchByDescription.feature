@regressionAG1
Feature: regression
  Search in product descriptions
  As I user I should be able to search for desired products
  Verify search returns products based on product description

  @TS001AG
  Scenario:
    Given I am on the home page
    When I enter the sample: "BrightView"
    Then I click the search button
    Then I choose Advanced search
    Then I choose Search In product descriptions
    Then I click the search button in a search block
    Then Click on first product which is displayed
    And The product description should contain sample "BrightView"

  @TS002AG
  Scenario Outline: Search in product descriptions
    Given I am on the home page
    When I enter the values:
      | keyword | <keyword> |
    Then I click the search button
    Then I choose Advanced search
    Then I choose Search In product descriptions
    Then I click the search button in a search block
    Then Click on first product which is displayed
    And The product description should contain "<keyword>"
    Examples:
      | keyword    |
      | BrightView |
      | phone      |

  @TS003AG
  Scenario: Verify search returns products from subcategories (automatically)
    Given I am on the home page
    When I enter the sample: "phone"
    Then I click the search button
    Then I choose Advanced search
    Then In Advanced search block select a parent category Electronics
    Then I click the search button in a search block
    And The result is displayed "No products were found that matched your criteria"
    Then In Advanced search block choose the box Automatically search subcategories
    Then I click the search button in a search block
    And Products with sample "phone" in the title should be displayed

  @TS004AG
  Scenario: Verify search returns products from subcategories (choosing subcategories manually)
    Given I am on the home page
    When I enter the sample: "phone"
    Then I click the search button
    Then I choose Advanced search
    Then In advanced search block select a subcategory Electronics Cell phones
    Then I click the search button in a search block
    And Products with sample "phone" in the title should be displayed