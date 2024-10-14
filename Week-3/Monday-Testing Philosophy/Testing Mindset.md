# Tester vs Developer Mindset
- Developer Mindset
    - I am going to make a working product
    - I am going to make this up as I go
        - I am going to prototype this first
    - I am going to design the structure of the application
    - I am going to write code that is efficient and understandable
        - My code will be scaleable
        - My code will follow best practices
        - My code will use up to date techniques
        - etc.
    - I am going to build the application my client wants
    - I am going to write well documented code

- qualities of a developer:
    - go getter attitude
    - positive mindset
    - things are going to go right
    - problem solver
    - goal oriented
    - detail oriented

- Inverted Mindset (we don't want this mindset as a developer)
    - I am going to make a broken product
    - I am going to have no plan whatsoever
    - I am not going to follow the plan
    - I am going to write code that is slow and impossilbe to understand
        - My code will not scale well
        - My code will not follow best practices
        - My code will not use up to date techniques
        - etc.
    - I am going to build the application my client didn't want
    - I am going to write no documentation

As a developer you want to avoid the inverted mindset, but as a TESTER you want to approach software with a "somewhat" inverted mindset. The danger in doing this is the risk of pitting the developers vs the testers.

# Why Test
- evalutate a product
- finding defects
    - a defect is any deviation from an expected outcome
- provide metrics to stakeholders
- build confidence in the product
- etc.

# Requirements
Anything that is needed for a product to be considered "finished" or anything that must be accomidated in the product you are working on is a "requirement". What constitutes a "requirement" is varied:
- technical requirement
    - "this app must work on linux and windows"
- software requirement
    - "this app must run on Java 11 or newer"
- business requirement
    - "this app must not store sensitive user information in plain text"
- security requirement
    - "this app must not allow unauthorized access"
    - "this app must not allow sql injection"
- accessibility requirement
    - "this app must support the full use of a screen reader for visual impaired users"
- regulatory requirement
    - "this app must be in compliance with the local governing body"

# Verification & Validation
- verification
    - static process
    - asking the question "are we building the right product"
        - reviewing documentation
        - reviewing source code
        - reviewing tools used to build product
- validation
    - dynamic process
    - asking the question "did we build the product right"
        - actively testing that requirements are met
        - acitvely confirming features are implemented