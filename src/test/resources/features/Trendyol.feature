Feature:Trendyol
  Background: Hompage
    Given I am on the Trendyol
    And Close Gender popup

  Scenario:Search Functionality
    When  I search for "kablosuk kulaklik"
    Then I should see that the search results include "kablosuk kulaklik"

  Scenario:Product Selection
    Given I am on the Trendyol
    When I search for "kablosuk kulaklık"
    And  I click on the first product in the search results
    Then I should be on the product details page
    And I should see the product details are displayed correctly

  Scenario: Add to Cart
    Given I am on the Trendyol
    And I search for "kablosuz kulaklik"
    When I click on the Add to Cart bottun for first product
    And I click on Goto Shopping Cart button
    Then I should see the product is added correctly with details

  Scenario: Cart Price Validation
    Given I am on the Trendyol
    And I search for "kablosuz kulaklik"
    When I click on the Add to Cart bottun for first product
    And I click on the Add to Cart button for the second product
    And I click on Goto Shopping Cart button
    Then I sholud see the total amount is shown correctly

  Scenario: Remove Item from Cart
    Given I am on the Trendyol
    And I search for "kablosuz kulaklik"
    When I click on the Add to Cart bottun for first product
    And I click on the Add to Cart button for the second product
    And I click on Goto Shopping Cart button
    And I click on remove button for the first item
    Then I should see that first item is removed from the cart


