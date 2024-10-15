# Testing Pyramid
- Unit Testing: testing the smallest cohesive part/s of an application
    - typically a single method or block of code
- Integration Testing: testing related parts of an application together
    - typically some feature of an application that requires multiple components to work together in order for the feature to work properly
    - multiple methods must work together properly for an integration test to pass
- System Testing: testing the whole of an application to confirm requirements can be met by the end user
    - all systems, components, parts, etc. of the application must be working correctly in order for system tests to pass
    - there are other kinds of System tests as well that are "non functional"
        - Typically these are "performance" tests
- Acceptance Testing: testing the intangibles of an application. These kinds of tests are typically going to include some subjective criteria and can be difficult to plan around

![testing pyramid](testing-pyramid.png)