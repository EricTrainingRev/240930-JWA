Feature: RegistrationUniqueUsername

	Scenario Outline: Automated User Registration Unique Username Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a valid password and a unique username, and if the username is not unique their account should not be created
		Given The user is on the login page at url "<Login Page URL>"
		When The user clicks the registration button
		When The user enters the username "<Username>"
		And The user enters the password "<Password>"
		And The user clicks the register button
		Then Then an alert should appear saying "<User Created>" for "<Username>"
		And The "<User redirected to login page result>"

	Examples: 
		| Username | Password                       | User Created     | User redirected to login page result | Login Page URL         |
		| Robin    | BatmanAndRobinToTheRescue20202 | User created     | User redirected to login page        | http://localhost:8080/ |
		| Batman   | BatmanAndRobinToTheRescue20202 | User not created | User remains on creation page        | http://localhost:8080/ |