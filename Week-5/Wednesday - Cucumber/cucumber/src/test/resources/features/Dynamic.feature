Feature: Cucumber can provide data dynamically as an argument to your step method
  Scenario Outline: Cucumber can pass data to step methods
    # wrapping the term in quotes tells Cucumber to dynamically provide
    # the associated data to the method that is associated with the
    # acceptance criteria at run time as an argument. See DynamicSteps
    # class for more details
    Given "<data>" is provided
  Examples:
    |data|
    |apple|
    |puppy|