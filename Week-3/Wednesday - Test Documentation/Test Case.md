# Test Case
When talking about test cases you are actually describing multiple resources:
- organizing principle
    - Use Case
    - User Story
    - etc.
- Scenario information
    - steps necessary to execute test
        - acceptance criteria
        - user instruction
        - test strategy
- Test Data
    - data/resources necessary to execute the testing for the test case
        - input data
        - environment data
            - pre-existing data in the database
            - session data
            - browser being used
            - operating system
            - etc.
- Actors
    - users or systems actively participating in your tests
        - end user
            - the tester
        - system being tested

## Example Test Case Creation: Planetarium User Registration
- Use Case Id: 1
- Description: Users should be able to open a new User account with the Planetarium
- Actors:
    - New User

### Test Data

#### Requirement: Usernames and passwords should not be longer than 30 characters
*Note: it is a good idea to separate your test data based upon what input or role it plays. With good logging it can be easy to parse similar data, but if there are any issues with the logging of an application it can become very difficult very quickly to parse out what role your test data was playing if you reuse it all over the place*

|0 character Username|30 characters Username|31 characters Usernames|
|-|--|--|
||BatmanAndRobinToTheRescue20202|JokerAndRiddlerAreAtItAgain1010|

|0 character Password|30 characters Password|31 characters Password|
|-|-|-|
||GordonIsMyHeroForeverGoodMan11|LexLuthorIsSchemingAgainOhNo!!!|

#### Requirement: Users should have unique usernames
*Note: you need to keep in mind ALL requirements when creating your test data since you need to be able to distinguish between your Positive test data (used for positive testing) and your Negative test data (used for negative testing)*
|Unique Username|Non-Unique Username|
|-|-|
|Robin|Batman|

#### Requirement: Passwords should never be visible in plaintext
*Note: because there are no "boundaries" or "classes" of data to work with for this requirement we need to employee a different strategy for organizing the test data. Specifically, we need to have a target that we look for which will act as our "test data". Since this data is going to be used for both our Exploratory Testing and our Error guess testing we should indicate this in some way here in our test data section*
- Password that should be obfuscated: "I am the night"
    - use for both Exploratory Testing and Error Guess Testing

#### Acceptance Testing Data
Use positive and negative test data found for [credentials length](#requirement-usernames-and-passwords-should-not-be-longer-than-30-characters) and [username uniqueness](#requirement-users-should-have-unique-usernames) depending on what kind of Acceptance Testing you are performing

#### Environment Data
- Browser: Edge
    - TODO: find specific version of Edge
- Operating System: Windows 10
- Version of Planetarium: 1.0
- Background Data:
    - Login Page for Planetarium: http://localhost:8080/

### Test Scenario
*Note: This is where everything is going to come together: we have used our documentation to help us organize our testing strategy, we've organized the actors and test data for our use case, now is the time to take all that data and think of test scenarios to validate whether the use case in question meets its requirements or if there are defects to be found. You can almost think of your test scenarios as the individual test cases: your scenarios will include the actors, associated test data, and expected end results of the scenario. All this data is required for your actual test execution*

*A common strategy for organizing your scenarios is to use a decision table: you plug your test data into a table with all possible combinations of that data and indicate what the expected end result of using said test data in the use case is*

|Username|Password|Account Creation Result|Redirect|
|-|-|-|-|
|(0 characters)|(0 characters)|User created|User redirected to login page result|
|(0 characters)|GordonIsMyHeroForeverGoodMan11|User created|User redirected to login page|
|(0 characters)|LexLuthorIsSchemingAgainOhNo!!!|User not created|User remains on creation page|
|BatmanAndRobinToTheRescue20202|(0 characters)|User created|User redirected to login page|
|BatmanAndRobinToTheRescue20202|GordonIsMyHeroForeverGoodMan11|User created|User redirected to login page|
|BatmanAndRobinToTheRescue20202|LexLuthorIsSchemingAgainOhNo!!!|User not created|User remains on creation page|
|JokerAndRiddlerAreAtItAgain1010|(0 character)|User not created|User redirected to login page|
|JokerAndRiddlerAreAtItAgain1010|GordonIsMyHeroForeverGoodMan11|User not created|User remains on creation page|
|JokerAndRiddlerAreAtItAgain1010|LexLuthorIsSchemingAgainOhNo!!!|User not created|User remains on creation page|

*Note: Once you have a handle on the ways you can use your test data for actually testing your Use Case, you are ready to write out the steps to enact your scenarios. A good tool to use for this is your Acceptance Criteria: you write out steps the actors involved in your use case would take in order to achieve your acceptance criteria, using your organized test data, and indicate the expected results of the steps taken*

|Step|Actor|Data|Result|
|-|-|-|-|
|given the user is on the login page|new user|http://localhost:8080/||
|when the user clicks the create account button|new user||should be redirected to the registration page|
|when the user provides {username} and {password} and clicks the create button|new user|{username},{password}||
|then the user should be given an alert saying {Account Creation Result}|new user||{Account Creation Result}|
|and {User Redirected to Login Page Result}|new user||{User Redirected to Login Page Result}|





