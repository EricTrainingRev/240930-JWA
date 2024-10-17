# Example Test Case Creation: Planetarium User Registration
- Use Case Id: 1
- Description: Users should be able to open a new User account with the Planetarium
- Actors:
    - New User

### Test Data

#### Requirement: Usernames and passwords should not be longer than 30 characters
|0 character Username|30 characters Username|31 characters Usernames|
|-|--|--|
||BatmanAndRobinToTheRescue20202|JokerAndRiddlerAreAtItAgain1010|

|0 character Password|30 characters Password|31 characters Password|
|-|-|-|
||GordonIsMyHeroForeverGoodMan11|LexLuthorIsSchemingAgainOhNo!!!|

#### Requirement: Users should have unique usernames
|Unique Username|Non-Unique Username|
|-|-|
|Robin|Batman|

#### Requirement: Passwords should never be visible in plaintext
- Password that should be obfuscated: "I am the night"
    - use for both Exploratory Testing and Error Guess Testing

#### Acceptance Testing Data
Use positive and negative test data found for [credentials length](#requirement-usernames-and-passwords-should-not-be-longer-than-30-characters) and [username uniqueness](#requirement-users-should-have-unique-usernames) depending on what kind of Acceptance Testing you are performing

#### Environment Data
- Browser: Edge
- Operating System: Windows 10
- Version of Planetarium: 1.0
- Background Data:
    - Login Page for Planetarium: http://localhost:8080/

### Test Scenarios

#### Decision Table For Username/Password Character Length Requirement Testing
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

#### Decision Table for Unique Username Requirement Testing
|Username|Password|User Created|User redirected to login page result|
|-|-|-|-|
|Robin|GordonIsMyHeroForeverGoodMan11|User created|User redirected to login page|
|Batman|GordonIsMyHeroForeverGoodMan11|User not created|User remains on creation page|

#### Parameterized Test Scenario
|Step|Actor|Data|Result|
|-|-|-|-|
|given the user is on the login page|new user|http://localhost:8080/||
|when the user clicks the create account button|new user||should be redirected to the registration page|
|when the user provides {username} and {password} and clicks the create button|new user|{username},{password}||
|then the user should be given an alert saying {Account Creation Result}|new user||{Account Creation Result}|
|and {User Redirected to Login Page Result}|new user||{User Redirected to Login Page Result}|





