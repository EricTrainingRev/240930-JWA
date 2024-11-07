# Levels of Testing

## Acceptance Testing

### Typical Objectives
Acceptance Testing is a process that allows for validating the application in question actually meets the requirements of the application owner and the end users to ensure the successful release of the application. This process not only creates confidence in the system as a whole but also ensures that the application is ready for release to users. While system defect identification is not the primary focus, discovering numerous defects may indicate substantial foundational issues within the application. Ideally, Acceptance testing should be done to validate the application, not verify its functionality (verification should be handled in the lower levels of testing)

### Common Types of Acceptance Testing
- User Acceptance Testing
    - The application handles all requirements needed by the end user
- Operational Acceptance Testing
    - Internal administrative tasks can be handled successfully
        - Data is appropriately backed up
        - Logs are generated correctly
        - Installing/un-installing work correctly
        - Security vulnerabilities are handled
- Contractual and Regulatory Acceptance Testing
    - Ensuring the application meets legal/contract requirements
        - Often done in association with an authority witnessing the testing
            - An auditor from the SEC might verify financial records can't be edited
- Alpha Testing
    - Internal testers/developers test an application to see if it works as intended
- Beta Testing
    - People outside the test/dev teams who are sample end users use the application
    - Spot any issues related to end user expectations

### Typical Defects
- Business rules not implemented or interpreted correctly
- Does not mean contract or regulatory requirements
- Poor performance and non-functional failures
    - images don't load correctly or scale incorrectly
    - page loading takes a long time
- Accessibility features don't work correctly

## System Testing

### Typical Objectives
System Testing involves verifying that functional and non-functional requirements are met when all systems are working together in an application. This includes the database, back end, front end, and supporting cloud infrastructure. Good System Testing can reveal novel defects that are undetectable by lower level testing, and a robust System Testing suite helps create confidence in the system as a whole.

### Common Types of System Testing
- End to End testing
    - verifying user actions can complete User Stories by fulfilling  Acceptance Criteria
- Performance testing 
    - verifying the application is responsive withing contractual obligations
    - verifying the application has the scaling potential as planned
- Load testing
    - verifying the application can handle the expected number of users
- Compatibility Testing
    - verifying the application works in different environments
        - different browsers
        - different operating systems
- Penetration Testing
    - verifying the security of the application is robust enough to withstands well known attacks

### Typical Defects
- Incorrect or unexpected functional behavior
- System does not conform to specifications
- Inability to complete all parts of end-to-end tasks
- Performance does not meet minimal requirements
- Application does not meet security requirements
- Cloud environment does not scale appropriately

# Types of Tests Revisited & Updated
- **Functional**
  - broad category of tests, relates to features that a user can use (i.e. WHAT the system does)
- **Non-Functional**
  - broad category of tests, relates to the way the software operates (i.e. HOW the system operates)
  - Can include:
    - Security
    - Usability
    - Compatibility
    - Performance
- **Static Testing**
  - broad category, refers to testing/examining a program's code without running it
    - using a linter to analyze the code
    - having a peer analyze the code
    - typically used to verify Quality Assurance practices are being followed
        - comments are being used appropriately
        - recommended versions of dependencies are being used
        - source code organization follows company best practices
        - git strategies are enforced
- **Dynamic Testing**
  - broad category, involves interacting with the system while the program runs
        - your typical Acceptance, System, Integration, and Unit tests will almost always fall under Dynamic Testing
- **White Box**
  - Testing with knowledge of the internal structure or code of the application
- **Black Box**
  - Testing functionality without knowing the internal structure or code
  - Only testing WHAT happens, not HOW the feature is implemented
- **Testing Pyramid**
  - **Unit Testing**
    - Testing of the smallest individual parts (units) of the application
    - Base of pyramid - most tests should be unit tests
  - **Integration Testing**
    - Testing the interactions of individual units working together
  - **System Testing**
    - Testing how the system functions as a whole
        - much manual testing is some form of System Testing
  - **Acceptance Testing**
    - user of the application validates that it satisfies their requirements
        - product owner validates correct application was created
        - regulatory body validates local ordinances are being followed
        - end user validates the application is intuitive and engaging
    - Top of pyramid, should have relatively fewer Acceptance Tests than others
- **Performance Testing**
    - testing how well an application works, not if it works or not
    - typically part of System Testing, but it can be Integration or Unit testing
    - types of Performance Testing:
        - **Endurance**: testing how long an application can be sustained under normal load
            - can reveal defects like memory leaks or poorly configured log management, or other defects that are only revealed over time
        - **Performance**: testing responsiveness and latency under normal load
            - often used when Service Level Agreements (SLAs) specify a level of performance a service should provide, such as time limits on latency or availability agreements
            - confusingly, performance testing is a kind of testing that falls under the category called "Performance Testing"
        - **Load**: measuring performance at differing loads of traffic
            - particularly useful if your service is deployed in an auto-scaling environment in the cloud, can reveal defects in the deployment environment
        - **Stress**: continually increasing the load of a service to capacity to identify the breaking point of the application
- **Compatibility Testing**
  - Testing that a feature or application works the same on different platforms, operating systems, browsers, etc
- **Regression testing**
  - testing done after one or more new features are implemented to check if the new feature/s broke old features
    - one of the major benefits of automated testing is the ability to quickly perform Regression Testing
- **Retesting**
  - testing done after making changes to fix a defect
- **Automated testing**
  - Not subject to human error
  - Quicker than manual testing
  - Initial upfront investment, but saves time in the long run
  - Reliable, can run 24/7
  - Can handle complex and large applications
  - Well suited for unit, integration, regression, and performance testing
- **Manual testing**
  - Subject to human error
  - Slower than automated testing
  - Easier for smaller or simpler applications or features
  - requires less upfront investment or technical knowledge
  - Well suited for Acceptance testing
- **Smoke testing**
  - Subset of acceptance testing, performed on entire system
  - Test that verifies basic and critical functionality to identify glaring defects (i.e. if there's smoke, there's fire)
  - Performed first in a build, so that if it fails we don't need to waste time testing more advanced features
  - e.g. for a calculator, testing that pressing the ON button causes the calculator to start: if this fails there is no point in checking its other features
  - can be thought of similar to a general health check up
- **Sanity testing**
  - Subset of regression testing, performed on specific feature
  - Performs a "sanity check" to verify functionality of a new feature works as intended
  - think of it as a smoke test for your regression testing: if your new feature/update has defects then old tests that interact with the new feature are going to fail as well
  - can be thought of as similar to a specialized health check up
- **Exploratory Testing**
  - Type of testing where test cases are not created in advance but instead on the fly in a White Box testing situation
  - The kind of tests to be created are determined by examining the source code and environment where the application will deploy
- **Error Guessing**
    - Type of testing where test cases are not created in advance but instead on the fly in a Black Box testing situation
    - the kind of tests to be created are determined by the tester and their experience working with similar applications in other projects
- **Alpha/Beta testing**
  - Alpha: initial round of Acceptance Testing, usually User Acceptance Testing. Typically internal people are used
  - Beta: limited release to specific end-users for testing, not limited to internal employees
- **Useability Testing**
  - testing the accessibility features of an application to determine the ease of use offered by the service

# Testing Techniques Revisited
- Positive / negative
  - Positive
    - verify the "happy path", or what happens when valid inputs are given
    - e.g. verify that a login form will redirect to the home page when valid username and password are entered
  - Negative
    - verify the "sad path", or the error states that can occur when invalid inputs are given
    - e.g. verify that a login form does NOT redirect to home page when invalid credentials are given
- Equivalence partitioning
  - Possible inputs to try are infinite, so break them up into "classes"
  - Choose a representative from each class to represent entire class
  - e.g. for testing calculator multiplication operation, partition inputs into negative, 0, and positive
  and have 3 test cases: one with negative number, one using 0, one using positive number
- Boundary value analysis
    - most defects occur at the boundaries of requirements, so instead of picking arbitrary values for your "classes" of data, like in Equivalence Partitioning, you pick values at the boundaries of relevant requirements
- State transition diagram
  - Identifies the different states of the system and the possibilities of navigating between the states
  - e.g. defect lifecycle is an example of state transition. project management tools model these states
- Decision tables
  - List all possible combinations of inputs and the resulting output
  - Provides visualization of test data and requirements
- Use Cases
    - a way of organizing test data and scenarios that need to be tested to verify requirements are being met
    - typically contains the following information
        - id
        - Use Case name
        - description
        - System being tested
        - preconditions
        - actors (software/people involved)
    - once the scenarios are determined and test data is organized for the Use Case then Test Cases can be created
