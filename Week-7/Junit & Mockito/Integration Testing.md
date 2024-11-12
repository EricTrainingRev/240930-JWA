# Integration Testing
- Integration testing is the process off testing how multiple components of your software work together
- Integration testing is useful for pinpointing where in your service a defect is located
    - System is useful for discovering defects are present: Integration testing is useful for locating where in your code those defects are located

## Integration Testing Types
- API Testing
    - validating an API returns expected results
        - **can test web servers**
        - can test gui
        - can test shell
        - etc.
- Incremental Testing
    - validating code modules work code section by code section
        - Top Down Testing
            - starting with the user interface and testing your way down to the components that interact with the database
        - Bottom Up Testing
            - starting with the components that interact with the database and working your way up to the user interface