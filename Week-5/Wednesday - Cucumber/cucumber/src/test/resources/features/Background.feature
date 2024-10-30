Feature: Shared initial Steps can be defined in a Background

  # if your scenarios in your feature have shared initial steps you
  # should group them in a Background section in order to reduce
  # redundancy in your feature file
  Background: Background for Scenarios One and Two
    Given Some shared starting point

  Scenario: Scenario One
    When  Action one happens
    Then  Result one Should happen

  Scenario: Scenario Two
    When  Action two happens
    Then  Result two should happen