# Testing Techniques
Testing Techniques are organizational strategies and tools for streamlining and facilitating the testing processes

## Use Case Testing
This strategy involves organizing user actions into use cases and facilitating your test scenarios and test data based off those use cases

## Black Box Testing & White Box Testing
Anytime you are testing an application without access to the source code you are doing "Black Box" testing. This kind of testing requires using the end results of the application to build your tests, along with documentation and conversation with relevant stakeholders to determine what needs to be tested

Anytime you are testing an application with access to the source code you are doing "White Box" testing. In this scenario the driving force that determines what you need to test is directly in the source code itself: this is content like methods, environment resources, internal configurations, any internal resource

In the testing pyramid, Black Box testing usually happens at the Acceptance and System level, White Box testing happens at all levels

## Black Box Testing: Boundary Value Analysis
- Requirements for new user Username
    - usernames must be unique
    - **usernames must be 5-15 characters long inclusive**
    - usernames must contain an upper and lowercase letter

|4 characters| 5 characters | 15 characters | 16 characters |
|------------|--------------|---------------|---------------|
| Bill       | Billy        |IamBATMAN200212|IamBATMAN2002128|


Because any requirement that creates a "boundary" for valid data will typically have defects when the boundary is either passed or reached, Boundary Value Analysis is a way of focusing your test data to check the "boundary" requirements of your application.

## Black Box Testing: Equivalence Partitioning
- Requirements for new user Username
    - **usernames must be unique**
    - usernames must be 5-15 characters long inclusive
    - usernames must contain an upper and lowercase letter

|unique username|non-unique username|
|---------------|-------------------|
| Billy         | SallyIsTaken      |

*note: this table assumes we as the testers have gone in and added a user with the non-unique username*

Whenever a requirement does not provide clean "boundaries" for your test data you will typically have too many possible data options to perform tests on (there are a LOT of potential usernames that are 5-15 characters, have an upper and lowercase letter, and can be unique). In these scenarios creating a "Equivalence Partition" table can be used to simplify the testing you need to do. For each "class" of data you need to test (in the case above unique and non-unique usernames that otherwise meet the requirements of the application) you pick a single value to represent the entire class. In the table above, if you try making an account with the unique username and succeed, you can safely assume ANY unique username that meets requirements would also lead to successfully creating an account. Likewise, if you try creating an account with the non-unique username and fail, you can safely assume ANY non unique username would likewise lead to a failed attempt, as you would expect

## Error Guess Testing & Exploratory Testing
Anytime you use your previous experience and knowledge of similar applications to think of test scenarios for an application, you are doing Error Guess Testing. This is a Black Box Testing technique because it requires you to use experience and testing knowledge to think of viable testing scenarios without fully understanding how an application works

Anytime you can "explore" the soure code of your application to look for code or features to be tested you are doing "Exploratory Testing". You bring all the same knowledge and understanding you would in Error Guessing but you also use your exploration of the source code to determine what needs to be tested and what your data should be 