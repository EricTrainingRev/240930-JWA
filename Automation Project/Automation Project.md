# JWA Automation Project
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to bring in testers to improve Quality Control to further improve product quality. The company was satisfied with the manual testing done last Sprint, and they would like for you and your team to build automated versions of your previous manual tests in order to streamline the testing process. Your Job this Sprint is to build an automated test suite to perform System testing on the planetarium application

## Project Technology Focus
- Java
- Selenium
- Cucumber
- Junit
- Jira
- Test Case Creation
- Test Reporting
- System Testing

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

## Test Software Requirements
- web page information should be saved in Page Object Models for ease of refactoring and updating
- feature files should be used to link Gherkin Acceptance Criteria to code execution in order to perform End to End testing
- A test runner class should be used to facilitate the End to End testing

## Defect Report Requirements
- All Defect Reports should include the following information
    - unique id
    - description
    - associated Test Object
    - associated Test Data

## MVP Goals
- All previous manual tests for System testing are automated
- Requirement Traceability Matrix contains Cucumber Acceptance Criteria
- Cucumber Acceptance Criteria are created for Use Cases
- Test Cases are saved in Jira
- Automated Tests are complete
- Test Results are saved in Jira
- Defect Reports are created for each failed test
- Defect Reports are saved in Jira

## Suggested Stretch Goals
- perform extra Error Guess Testing
- perform Non-Functional System testing
- perform extra Acceptance Testing

## Order of Operations: Second Sprint

### 1. Requirement Analysis
**Entry Criteria:**
- Requirements document is available
- Stakeholder is available for clarification
- Test Results from the first sprint are available

**Exit Criteria:**
- Requirements are understood
- Acceptance Criteria updated
- RTM updated with new requirements
- Test Results are aggregated
- Defect Reports are aggregated

### 2. Test Planning
**Entry Criteria:**
- Updated RTM is available
- Results from the first sprint analyzed

**Exit Criteria:**
- Test plan documentation is updated
- Automation strategy is defined

### 3. Test Case Development
**Entry Criteria:**
- Updated test plan is available
- RTM is up to date

**Exit Criteria:**
- Automated test cases are written and reviewed
- Test data is prepared

### 4. Test Environment Setup
**Entry Criteria:**
- Automated test cases are written
- Test data is defined
- Setup resources are available

**Exit Criteria:**
- Test environment is configured
- Automated smoke tests all pass

### 5. Test Execution
**Entry Criteria:**
- Automated test cases are developed and reviewed
- Test environment passes automated smoke tests

**Exit Criteria:**
- Automated test cases are executed
- Defects are logged in Jira
- Test results are documented in Jira

### 6. Test Cycle Closure
**Entry Criteria:**
- Test execution is complete
- All defects are logged and tracked

**Exit Criteria:**
- Test summary report is updated
- Presentation for Stakeholder has been prepped
- Documentation is updated with new estimates and findings

## Setup Requirements
- an environment variable called "PLANETARIUM" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "PLANETARIUM" environment variable
-  start the application with the command ```java -jar path/to/Planetarium-1.0-shaded.jar```

## Agile Practices
- **Daily Scrum**:
  - Update on previous day's work
  - Plan for today's work
  - Discuss blockers
  - Save notes in Jira/Confluence/GitHub for tracking
  - Keep the meeting simple and focused
- **Sprint Board**:
  - Assign and update issue statuses to avoid duplicate work
- **Pair Programming**:
  - Roles: Driver (writes code) and Navigator (reviews code)

## Git Practices
- **Protect Main Branch**:
  - Prevent direct pushes to avoid breaking changes
- **Enforce Code Reviews**
  - require 1 or 2 reviewers for all pull requests in Github
- **Branching Strategy**:
  - Standard naming convention for clarity
  - Define frequency for adds and commits
  - Agree on commit message style (active/passive voice, commit type, associated issue id, etc.)


