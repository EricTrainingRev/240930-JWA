Feature: RegistrationCharacterLimit

	Scenario Outline: User Registration Username/Password 30 character Limit Requirement Test Case
	Validating Users can open a new User account with the Planetarium when they provide a username and password that meet the character limit requirement, and if they don't their account should not be created
		Given The user is on the login page at url "<Login Page URL>"
		When The user clicks the registration button
		When The user enters the username "<Username>"
		And The user enters the password "<Password>"
		And The user clicks the register button
		Then Then an alert should appear saying "<Account Creation Result>"
			"""
			<Username>
			"""
		And The "<User redirected to login page result>"

	Examples: 
		| Login Page URL         | Username                        | Password                        | Account Creation Result | User redirected to login page result |
		| http://localhost:8080/ | (no values)                     | (no value)                      | User created            | User redirected to login page        |
		| http://localhost:8080/ | (no values)                     | GordonIsMyHeroForeverGoodMan11  | User created            | User redirected to login page        |
		| http://localhost:8080/ | (no values)                     | LexLuthorIsSchemingAgainOhNo!!! | User not created        | User remains on creation page        |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | (no value)                      | User created            | User redirected to login page        |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | GordonIsMyHeroForeverGoodMan11  | User created            | User redirected to login page        |
		| http://localhost:8080/ | BatmanAndRobinToTheRescue20202  | LexLuthorIsSchemingAgainOhNo!!! | User not created        | User remains on creation page        |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | (no value)                      | User not created        | User remains on creation page        |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | GordonIsMyHeroForeverGoodMan11  | User not created        | User remains on creation page        |
		| http://localhost:8080/ | JokerAndRiddlerAreAtItAgain1010 | LexLuthorIsSchemingAgainOhNo!!! | User not created        | User remains on creation page        |