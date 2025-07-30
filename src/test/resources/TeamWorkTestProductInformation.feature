@regressionSS1

Feature: Basic HTML Form Testing
  As a user
  I want to check if products on Website display required information

  @TC001SS1
  Scenario Outline: The product page displays required information (Products in "Book" category)
    Given I navigate to the "Book" section page
    When I open a <product>
    And I am redirected to the product page
    Then I can see all required information about this product
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |
      | 5       |
      | 6       |


  @TC002SS1
  Scenario Outline: The product page displays required buttons (Products in "Book" category)
    Given I navigate to the "Book" section page
    When I open a <product>
    And I am redirected to the product page
    Then I can see "Add to compare list" button is displayed
    And I can see "Add to Cart" button is displayed
    And I can see "Add to Wish List" button is displayed
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |
      | 5       |
      | 6       |

  @TC003SS
  Scenario Outline: The product page displays available options (Products in "Desktop" subcategory)
    Given I navigate to the subsection "Desktop" page
    When I open a <product>
    And I am redirected to the product page
    Then I can see "Available options" attributes are displayed
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |
      | 5       |
      | 6       |

  @TC001SS2
  Scenario Outline: The product page displays required information (Products in "Camera, photo" subcategory)
    Given I navigate to the "Camera, photo" subsection page
    When I open a <product>
    And I am redirected to the product page
    Then I can see all required information about this product
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |

  @TC002SS2
  Scenario Outline: The product page displays required buttons (Products in "Camera, photo" subcategory)
    Given I navigate to the "Camera, photo" subsection page
    When I open a <product>
    And I am redirected to the product page
    Then I can see "Add to compare list" button is displayed
    And I can see "Add to Cart" button is displayed
    And I can see "Add to Wish List" button is displayed
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |

  @TC001SS3
  Scenario Outline: The product page displays required information (Products in "Gift card" category)
    Given I navigate to the "Gift card" section page
    When I open a <product>
    And I am redirected to the product page
    Then I can see all required information about this product
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |

  @TC002SS3
  Scenario Outline: The product page displays required buttons (Products in "Gift card" category)
    Given I navigate to the "Gift card" section page
    When I open a <product>
    And I am redirected to the product page
    Then I can see "Add to compare list" button is displayed
    And I can see "Add to Cart" button is displayed
    And I can see "Add to Wish List" button is displayed
    Examples:
      | product |
      | 1       |
      | 2       |
      | 3       |
      | 4       |