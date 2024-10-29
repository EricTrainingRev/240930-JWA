# Every Feature File will have a similar structure: The first
# Non comment resource declared in the file should be the
# "Feature" the file is for. In this example, our Feature is
# "Cafe Login", so this indicates that all "Scenarios" with
# Acceptance Criteria in the file should pertain, in some way,
# to the Cafe Login feature of the product we are working on. Note
# that your Feature could be your User Story, or a generic descriptor
# for the functionality/feature the User Story describes
Feature: Cafe Login

# Once you have a feature you need scenarios that play out the
# Feature in action: these scenarios can be your User Stories if
# they are simple, but more likely your scenarios are going to be
# individual Use Cases that spawn from the User Story. There are two
# kinds of Scenarios: regular scenarios, and scenario outlines. We will
# look at the outline version after the regular version
    Scenario: Customer With Valid Credentials Can Log In

# Now that we have a scenario we need to map some Acceptance Criteria to the scenario.
# Depending on whether the application/service already has code/work complete, you may need
# to determine how the scenario will be accomplished at this time, or if the application has
# already had this particular feature developed, you simply map the expected actions of the
# user to the Scenario. 
#
# In Gherkin, there are some key semantic words that are used to indicate new steps in your
# Acceptance Criteria. The following key words can be used:
# - Given
# - When
# - Then
# - And
# - But
# From a technical standpoint, these key words do not provide any special meaning for our Acceptance
# Criteria or any automation work we will do with future feature files. What they provide is
# semantic meaning: all of these key words have "intended" meanings for their use, but you are 
# not technically required to use them for their intedned meaning. That being said, it is good
# practice to use them for their intended meaning: future you will be grateful, and future team
# memebers that work with your Acceptance Criteria will also be grateful
#
# With this in mind, we can write out some simple Acceptance Criteria for the given scenario:
# given valid credentials a user should be able to log in (positive scenario)
        Given   The Customer is on the login page
        When    The Customer provides valid credentials
        And     The Customer clicks the login button
        Then    The Customer should be logged in
        And     The Customer should be redirected to the home page

# Notice how the Gherkin key words are meant to provide context for the Acceptance Criteria step:
# Given sets the starting condition, When/And provides the actions taken, Then/And provides the
# expected outcome
#
# If we wanted a negative version of this scenario we would need to make a new Scenario section
# and assocaite new Acceptance Criteria steps to the Scenario. Note that if we want to be more
# robust in our testing we would want a minimum of three different scenarios: one where all 
# credentials are incorrect, and a scenario for password and username alone being incorrect
    Scenario: Customers With Invalid Credentials Can Not Log In
        Given   The Customer is on the login page
        When    The customer provides invalid credentials
        And     The Customer clicks the login button
        Then    The Customer should be alerted that the login attempt failed

    Scenario: Customers With Invalid Passwords Can Not Log In
        Given   The Customer is on the login page
        When    The customer provides invalid password
        And     The customer provides valid username
        And     The Customer clicks the login button
        Then    The Customer should be alerted that the login attempt failed

    Scenario: Customers With Invalid Usernames Can Not Log In
        Given   The Customer is on the login page
        When    The customer provides invalid username
        And     The customer provides valid password
        And     The Customer clicks the login button
        Then    The Customer should be alerted that the login attempt failed

# The scenarios above would work, but there are still issues: What if we want differing alerts
# depending on the fail condition? The above example in the "Then" statement implies that all
# scenarios will have the same fail statement occur. For a login that is probably fine, but for
# other features, such as registration, adding items to a shoping cart, etc., you will most
# likely have unique fail messages that need to be accomodated in your Acceptace Criteria.
# One way of simplifying your Scenarios, especially when you a have group of Scenarios that
# only differ in the data being provided to them (think your various test scenarios based off
# a decision table) we can use a "Scenario Outline" to make our lives easier. Scenario Outlines
# allow you to design your Acceptance Criteria with parameters, whose values you can provide
# during testing from an "Examples" table. In your Scenario Outline any place where you need to
# inject some data you provide a parameter name and wrap it between diamond brackets. Then in your
# Examples table you provide the data that needs to be injected in the Acceptance Criteria
    Scenario Outline: Customer With Invalid Credentials Can Not Log In
        Given   The Customer is on the login page
        When    The customer provides password of <password>
        And     The customer provides username of <username>
        And     The Customer clicks the login button
        Then    The Customer should be alerted that the login attempt failed

    Examples:
        |password|username|
        |invalid |invalid |
        |valid   |invalid |
        |invalid |valid   |

# If you take a close look at the positive scenario and the negative scenario outline, you will
# see there are two shared Acceptance Criteria, the Given starting condition and an And action to
# click the login button. The button click we can't do much about: both scenarios need to complete
# that action and do so at differing times, so we have to include it in both scenarios. What we
# can do is simplify our given statements by adding a "Background" section to the feature file.
# This indicates that all scenarios, whether solo or scenario backgrounds, share one or more
# starting steps.
    Background: Login starting point
        Given   The customer is on the login page

# By using a Background you can reduce the number of Acceptance Criteria you explicitly write, 
# but it will still be understood that your Given statements are assocaited with each Scenario
# of the Feature. Note that a Background should be placed before