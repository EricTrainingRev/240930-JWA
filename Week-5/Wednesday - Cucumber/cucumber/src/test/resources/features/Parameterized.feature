Feature: Cucumber can Manage Parameterized Scenarios
  Scenario Outline: We can Inject Data Into our Scenarios
    # We can reuse Acceptance Criteria across multiple feature files
    Given Some first step
    # we can wrap a term in diamond brackets to tell Cucumber to inject a value in its place
    When  <action> is provided
    Then  Some expected result
  # "apple" and "puppy" will replace "<input>" when cucumber executes tests for this feature file:
  # a unique step for the apple and puppy data will be generated, allowing us to perform unique actions
  # based upon the given data
  Examples:
    |action|
    |apple|
    |puppy|