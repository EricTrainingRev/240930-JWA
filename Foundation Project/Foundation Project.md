# JWA Foundation Project
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to bring in testers to implement Quality Control to further improve product quality. Your job this Sprint is to perform manual testing on the application  with two main goals: to look for defects in the product, and to give feedback on the user experience working with the app

## Project Technology Focus
- Jira
- Manual Testing
- Test Case Creation
- Test Reporting
- System Testing
- Acceptance Testing

## Project Test Objectives
- defect discovery
- requirements validation
- useability reporting

## Use Cases
- Users should be able to open a new User account with the Planetarium
- Users should be able to securely access their account
- Users should be able to see planets and moons added to the Planetarium
- Users should be able to add new Planets to the Planetarium
- Users should be able to remove Planets from the Planetarium
- Users should be able to add Moons to the Planetarium associated with a Planet
- Users should be able to remove Moons from the Planetarium

## Security Requirements
- Passwords should never be visible in plaintext
- Users should only be able to interact with resources they have added to the Planetarium
- Only logged in Users should be able to access the Planetarium home page

## Software Requirements  
- Users should have unique usernames
- Usernames and passwords should not be longer than 30 characters
- Planet and Moon names should not have more than 30 characters
- Planets and moons should have unique names
- Planets should be “owned” by the user that added it to the Planetarium
- Moons should be “owned” by the Planet the User adding the moon associated it with
- Planets and Moons should allow adding an associated image, but an image should not be required for the data to be added to the database

## Testing Requirements
- All Test Reporting should be done in Jira
- All Use Cases require a minimum of one positive test
- All Use Cases with associated software requirements require negative testing to verify requirements are met
- All Use Cases with Software Requirements that limit data **input** require Boundary Analysis Testing
- All Use Cases with Software Requirements that limit data **visibility** require Error Guess Testing
- All Use Cases with Software Requirements that limit data **interaction** require Error Guess Testing
- All tests that fail should be logged in a Defect Report inside of Jira
- Acceptance testing for the user experience should answer the following questions in detail:
    - Is the intended use of the service intuitive?
    - Is the service easy to use?
    - Does the service inspire confidence?
    - Is the service pleasing to look at?

## Defect Report Requirements
- All Defect Reports should include the following information
    - unique id
    - description
    - associated Test Object
    - associated Test Data

## MVP Goals
- Test Cases are created for Use Cases
- Test Cases are saved in Jira
- Manual Tests are complete
- Test Results are saved in Jira
- Defect Reports are created for each failed test
- Defect Reports are saved in Jira

## Suggested Stretch Goals
- perform extra Error Guess Testing
- perform Non-Functional System testing

## Order of Operations

### 1. Requirement Analysis
**Entry Criteria:**
- Requirements document is available.
- Stakeholder is available for clarification.

**Exit Criteria:**
- Requirements are understood
- Acceptance Criteria created
- Initial RTM created

### 2. Test Planning
**Entry Criteria:**
- RTM created

**Exit Criteria:**
- Test plan documentation is created

### 3. Test Case Development
**Entry Criteria:**
- Test plan is up to date
- RTM up to date

**Exit Criteria:**
- Test cases are written and reviewed
- Test data is prepared

### 4. Test Environment Setup
**Entry Criteria:**
- Test cases are written
- Test data is defined
- setup resources are available

**Exit Criteria:**
- Test environment is configured
- Smoke tests all pass

### 5. Test Execution
**Entry Criteria:**
- Test cases are developed and reviewed
- Test environment passes smoke tests

**Exit Criteria:**
- Test cases are executed
- Defects are logged in Jira
- Test results are documented in Jira

### 6. Test Cycle Closure
**Entry Criteria:**
- Test execution is complete
- All defects are logged and tracked

**Exit Criteria:**
- Test summary report is created
- Presentation for Stakeholder has been prepped

## Setup Requirements
- an environment variable called "PLANETARIUM" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "PLANETARIUM" environment variable
-  start the application with the command ```java -jar path/to/Planetarium-1.0-shaded.jar```


## Presentation Requirements
- shoot for a 5 minute presentation
- have your test reports ready to go
- share a github repo link with your trainer before you start your presentation
- A couple recommendations
    - write down what you want to say
    - organize your desktop/browser so all the content you need is prepared when you start your presentation

## Presentation Order of Operations
1. Present Test Summary Report
    - give a brief overview of the scope of your testing
    - describe 1-3 meaningful discoveries made by your testing
        - high severity defects
        - interesting edge cases
2. Showcase Acceptance Testing Summary Report
    - give a brief overview of your acceptance testing
    - describe 1-3 meaningful discoveries made by your testing
        - all use cases inspired confidence
        - no use cases inspired confidence
        - majority of use cases were pleasing to look at
        - etc.
3. Perform mini Sprint retrospective
    - what went well in the Sprint?
        - you had a good understanding of the work
        - you were quick to implement your test strategy to streamline work
        - you came up with a way to automate much of the setup/tear down for resetting your test environment between tests
        - etc.
    - what can be improved for next Sprint?
        - did you underestimate how long a phase would take to complete?
        - did you do a poor job of implementing your chosen testing techniques?
        - did you fall behind your schedule and have to rush to finish your work?
        - etc.
    - what work needs to be done next Sprint?
        - do you have more tests to execute?
        - are there edge cases you discovered that you want to test?
        - are there new testing strategies you can implement next sprint?
        - do you need to update your Story Points / Velocity estimates?
        - etc.
4. Field questions

**NOTE**: please save your talking points for your Sprint Retrospective and save them along with your other test documentation in your project github repo