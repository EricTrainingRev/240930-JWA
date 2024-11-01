Feature: English readers can read through Wikipedia in English
  Scenario: Clicking the English link should take you to the English Wikipedia Homepage
    Given User is on the Wikipedia home page
    When  The User clicks the English link
    Then  The User should be redirected to the English Wikipedia Homepage