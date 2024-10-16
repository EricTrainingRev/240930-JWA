# Test Documentation

## Requirements Traceability Matrix
This document is used to map features of an application with its associated requirements. Oftentimes an RTM will also map acceptance criteria to the features of the application. Often RTMS are also used to link features with their associated Use Cases, User Stories, Epics, individual test cases, test results, who is responsible for the feature, and just about any other resource that should/can be tracked for the application

## Test Plan
The Test Plan is one or more documents that provide instructions and guidance for how a team will test a product.This documentation will include details such as:
- Test Strategy
- Test Schedule
- RTM
- Software Requirements Specification
- Test Progress Report
- Test Summary
- etc.

Ultimately, the Test Plan is a coordination tool: it provides organization for the many moving parts of a testing project and should always be considered your central source of truth concerning your project

## Test Strategy
This documentation is a component of the Test Plan that provides detailed information about the testing activities associated with your product:
- testing strategies to use
    - what strategies to use for each use case
- testing objectives
    - what is the goal of your testing? Broadly or narrowly speaking
- Effort Estimate
    - How long work should/does take
- Cost Estimate
    - how much money will it take to perform the testing

## Test Schedule
This documentation should provide details on when work should start, when the work should end, and any other timely details about the project you are working. This can include deadlines, on-boarding dates, meetings with stakeholders, etc.

## Software Requirements Specification
This documentation tells you about the features and requirements of the product you are testing. This documentation should include information such as:
- what are you supposed to be able to do with the application?
    - features
- what are the requirements of the application
    - functional requirements
        - *features*
    - non-functional requirements
        - performance requirement
            - latency requirements (requests handled in 200 miliseconds or less)
        - security requirements
            - no plain text passwords
        - accessibility requirements
            - optimized for screen readers
        - regulatory requirements
            - in compliance with personal data laws
- API information
    - how to actually interface with the product you are testing
        - REST API
        - SSH
        - Desktop Application
        - Mobile Application
        - etc.

## Test Progress Report
This documentation is used to keep track of work that has been done. It is particularly useful when you need to update stakeholders on the progress of your testing endeavors.
- what testing has been done?
    - what are the results of the tests that have been done?
- is the test schedule being adhered to?
    - are you on track with your work?
- what still needs to be done

## Test Summary Report
This report is generated at the end of a test cycle to provide detailed information on the results/progress of the testing work
- think of this as a more comprehensive Progress Report: instead of marking work as "todo" if it was not completed you would instead mark it as "incomplete"