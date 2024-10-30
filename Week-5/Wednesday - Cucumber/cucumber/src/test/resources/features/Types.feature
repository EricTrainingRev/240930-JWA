Feature: Cucumber supports working with multiple types of data
  Scenario Outline: numeric types can be injected
    # make sure if working with non strings not to wrap in quotes
    Given <number> unique data provided
  Examples:
    |number|
    |10  |
    |5   |

  Scenario Outline: boolean types can be injected
    Given What is <truth>
    Examples:
    |truth|
    |true |
    |false|

  Scenario Outline: strings require quotes for the data
    # Since we are working with String data wrap the data name in quotes
    Given Some "<word>" input
  Examples:
    |word|
    |apple|
    |puppy|
