Feature: Cafe Login
    Background: Cafe Login Starting Step
        Given   The Customer is on the login page    
    Scenario: Customer With Valid Credentials Can Log In
        When    The Customer provides valid credentials
        And     The Customer clicks the login button
        Then    The Customer should be logged in
        And     The Customer should be redirected to the home page
    Scenario Outline: Customer With Invalid Credentials Can Not Log In
        When    The customer provides password of <password>
        And     The customer provides username of <username>
        And     The Customer clicks the login button
        Then    The Customer should be alerted that the login attempt failed
    Examples:
        |password|username|
        |invalid |invalid |
        |valid   |invalid |
        |invalid |valid   |