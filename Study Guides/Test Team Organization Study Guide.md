# Test Team Organization Study Guide

## Test Documents

### Test Plan
The **Test Plan** is a comprehensive document that outlines how a team will manage testing for a product or system, including details such as the test strategy, objectives, schedule, estimates, and deliverables of a project. This document serves as a central hub, specifying the need for other documents such as the test case document and the requirements traceability matrix. It is sometimes referred to as a master test plan, level test plan, or test scope. Ultimately, the **Test Plan** is meant to coordinate testing activities effectively, ensuring that all aspects of the testing process are covered and aligned with the overall goals of the project

### Test Strategy
The **Test Strategy** is a component of the Test Plan that provides an in-depth description of the testing activities to be done and the methods to achieve them. It outlines the specific approaches and techniques to be used, and may also include detailed estimations of cost and effort required for the testing activities. By defining the scope, objectives, and resources needed, the Test Strategy helps ensure the testing process is well-organized and efficient

### Test Schedule
The **Test Schedule** is a document that outlines the timeline for completing various testing activities. It specifies when each part of the software needs to be tested in order to facilitate timely testing. In an Agile development environment, this schedule is a living document, meaning it is continuously updated and adjusted as the project progresses. This flexibility allows the team to adapt to changes and unforeseen challenges, ensuring that testing remains aligned with the overall project timeline. The **Test Schedule** also helps in coordinating efforts across different teams, preventing bottlenecks and ensuring that resources are allocated efficiently. Maintaining a well-structured test schedule can help ensure that all critical aspects of the test objects are tested, which makes it easier to handle unexpected problems when they arise

### Requirements Traceability Matrix
The **Requirements Traceability Matrix** (RTM) is a document that visualizes the relationship between System Requirements/User Stories and the Test Cases that cover those requirements. It can also track any defects revealed after testing. This means the **RTM** maps requirements to their specific test cases, which helps with maintaining traceability and ensuring comprehensive test coverage

### Software Requirements Specification
A **Software Requirements Specification** (SRS) document is a detailed and structured description of the software system to be developed. It serves as a comprehensive guide for both the development team and stakeholders, outlining the **functional** and **non-functional requirements** of the software. The core of the **SRS** is the **functional requirements** section, which specifies the specific behaviors or functions the software must perform. Additionally, the **non-functional requirements** section covers performance, security, usability, and other quality attributes the software must meet. The document also includes external interface requirements, specifying how the software will interact with other systems or hardware, and design constraints, listing any limitations or constraints that affect the design or implementation. An **SRS** is crucial for ensuring clarity and alignment among all stakeholders, providing a blueprint for the development team, and serving as a basis for **validation** to the testing team

### Test Progress Report
The **Test Progress Report** is a document used to track the progress of tests designed and executed, providing a clear overview of testing activities. This report works in conjunction with the Test Schedule by providing detail on the status of the various tests completed and in progress. It includes details such as the number of test cases executed, passed, failed, and any defects identified during the testing process. By maintaining an up-to-date Test Progress Report, teams can monitor their progress, identify any bottlenecks or issues early, and make informed decisions to ensure the quality and reliability of the software

### Test Summary Report
The **Test Summary Report** is a document used to aggregate and display the results of test case executions associated with one or more test objects. Partial reports may be included in a Test Progress Report, but the entirety of the test results should be saved in their own documentation. Typical **Test Summary Reports** are organized by test runs or test cycles: this is a way of distinguishing the results of the test cases between development/testing cycles. **Test Summary Reports** include similar information to a Test Progress Report: test cases executed, status of test cases, and defects identified during testing. **Test Summary Reports** provide a basis for Test Progress Reports. These reports are often generated at different milestones and are compared against exit criteria to determine whether development and testing should progress

## Testing Lifecycles

### Standard Testing Life Cycle

#### Requirement Analysis
At the start of the Software Testing Lifecycle is the Requirement Analysis Phase, in which the test team studies the software requirements to identify what systems must be tested and potentially discuss requirements with stakeholders to understand all details. Requirements may be function or non-functional, and a Requirements Traceability Matrix should be designed at this time
- **Entry Requirements**
    - Requirements Document Available (functional and non-functional)
    - Acceptance Criteria Defined
    - Application Architecture documentation available
- **Exit Requirements**
    - RTM has been approved

#### Test Planning
During the Test Planning Phase a Testing Manager or senior member will draft the test plan and calculate the level of effort and cost estimates for the project. During this phase the resources, test environment, test limitations and schedules are also determined
- **Entry Requirements**
    - RTM available
    - Requirements Documents available
- **Exit Requirements**
    - Test Plan Document approved
    - Effort Estimation approved

#### Test Case Development
The Test Case Development Phase sees the creation of test cases, test scripts and any required test data using the established test plan. These components are then reviewed and refactored as needed to meet the requirements of the product. This phase can be done in parallel with the Test Environment Setup
- **Entry Requirements**
    - Requirements, RTM and Test Plan Documents Available
- **Exit Requirements**
    - Test cases planned and initial scripts created
    - Test Data has been created

#### Environment Setup
During the Test Environment Setup, software and hardware conditions, which replicate the conditions of the work product, are created and tested. This phase can be done in parallel with the Test Case Development Phase
- **Entry Requirements**
    - System Design and Architecture Documents available
    - Environment set-up plan established
- **Exit Requirements**
    - Environment ready with test data established
    - Smoke Test Results show no problems with environment

#### Test Execution
Developed Test cases are carried out by the testers during the Test Execution Phase. This process consists of test script execution, script maintenance, reporting bugs, retesting, and generating reports
- **Entry Requirements**
    - RTM and Planned test cases are available
    - Test environment is ready
- **Exit Requirements**
    - All planned tests are executed
    - Found defects are logged and tracked to their closure

#### Test Cycle Closure
The final phase, Test Cycle Closure, marks the completion of test execution and involves several activities, including a meeting to discuss and analyze the reports and other artifacts and identify successful strategies and takeaway lessons from the test cycle
- **Entry Requirements**
    - All testing has concluded
    - Test results are available
    - Defect logs are available
- **Exit Requirements**
    - Closure of Testing is signed off by client
