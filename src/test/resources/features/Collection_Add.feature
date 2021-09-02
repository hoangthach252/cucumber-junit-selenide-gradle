@regression @add-collection
Feature: Add Collection

  @id-001 @add-search-result
  Scenario: Add search result picture into new Collection111111111.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    When he searches pics with keyword "Cute Puppies"
    And he adds the first image into new collection name "Cute Puppies Collection"
    And he navigates to his collection page
    Then he can see the new collection is added in his collection


  @id-002 @add-search-result
  Scenario: Add search result picture into new Collection 2.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    When he searches pics with keyword "Cute Puppies"


  @id-003 @add-search-result
  Scenario: Add search result picture into new Collection 3.
    Given the user is on the main page
    And the user goes to Login Page
    And the user logs in "zenautomator101" credential
    When he searches pics with keyword "Cute Puppies"