# Test Driven Development (TDD)
Test Driven Development is a process where tests provide developers with targets to achieve. So the order of operations looks something like this:
1. Requirements are defined
2. Tests are written that are meant to validate those requirements are met
3. Code development happens with the intent of passing the tests developed in the previous step

There are some benefits to this:
- Helps prevent feature creep: by giving the developers hard targets for their work, it makes it less likely the developers will add extraneous code to the application
- Helps blend testing and development: because test development happens first, it simplifies the process of validating that your software is working as intended. All a developer needs to do to validate their code works is to execute the tests

BDD and TDD are compatible with each other:
1. Requirements are defined
2. Acceptance criteria is created
3. Tests are written to validate acceptance criteria is met
4. code is written to pass tests