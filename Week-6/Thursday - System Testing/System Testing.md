# System Testing
- the process of testing that a system works as a cohesive unit
    - can be functional
        - does the entirety of the login feature work correctly?
    - can be non-functional
        - does the login feature work when multiple concurrent users try to log in?

## Common System Test Types
- End to End Testing
    - validating user actions can complete User Stories by fulfilling Acceptance Criteria
- Performance Testing
    - validating the application is responsive within contractual obligations
        - does not have to be for contractual agreements: you can run performance tests to determine when/how your application should scale
- Load Testing
    - validating the application handles user traffic as expected
    - Stress Testing
        - increase user interaction with your application until it breaks to determine how many users/actions your application can handle reasonably
    - Spike Test
        - this kind of test "spikes" the number of users/actions your application is handling for a moment before returning to regular use
            - This is useful for seeing how your application handles an influx of requests, and it can also reveal defects in your application deployments
                - can the computer your application is hosted on handle the influx of requests/interactions?
                - if your application stores permanent logs, will the influx of user traffic overwhelm your logging system?
    - Endurance Test
        - running your application and sending it the expected regular amount of traffic over a long period of time to try and discover defects that can only be found after a long time has passed
            - memory leaks
            - poorly optimized logs
            - etc.
- Compatibility Testing
    - validating the application works in various environments
        - does the app work on mobile?
        - does the app work on linux/windows/mac?
        - does the web app work in x/y/z browsers?
            - does the web app work in older version of browsers?
- Security Testing
    - validating the application is resistant to unintended/malicious use
    - Penetration Testing
        - validating the security of an application handles well known attacks efficiently
        - also covers physical security: how easy/difficult is it for a bad actor to gain physical access to the servers of your application?