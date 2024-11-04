# BDD -Gherkin & Cucumber Study Guide

## Behavior Driven Development
Behavior Driven Development (BDD) is the practice of performing development from the perspective of the end user. It takes into account the user experience, expectations, actions, etc. If you can think of something the end user might consider with your intended application, it should be considered. This approach should affect the way you think about all the parts of your application

### End to End Testing
A common practice in BDD is End to End testing: this is the process of simulating an end user interacting with the system you are building, usually in an automated fashion:
- log in to a service
- create an account
- adding an item to a shopping cart
- removing data from a list on the website
- etc.

### E2E testing: organization of User Stories
When organizing your E2E tests, User Stories are used to organize and determine what needs to happen to represent the end user interacting with the service. For the purposes of training we will make use of the following syntax to guide our User Story creation process:
- As a
    - customer
    - employee
    - puppy
    - etc.
    - new user
    - potential user
    - long time user
- I want 
    - to log in
    - to log out
    - to add a specific item to my shopping cart
    - to scratch the furniture
    - to create an account with the service
    - etc.
        - note that these "I want"s are specific
- So that
    - I can order my coffee
    - I can save it for ordering later
    - I can get my owner to pay attention to me
    - etc.

When creating your User Stories keep in mind that you will more likely than not need to change or update the document, so make sure whatever tool you use to save your User Story information is flexible and allows for easy changes.

### E2E Testing: Creating Acceptance Criteria
Once you have your User Stories (or at least the initial User Stories, since there may be updates) you need to have a way to determine whether a User Story is completed successfully or not with your automated steps. One way of doing this is through the use of Acceptance Criteria. Acceptance Criteria is a collection of actions the end user takes in order to complete the User Story. A common way of framing Acceptance Criteria is to use Gherkin Syntax. By using Gherkin Syntax we will eventually be able to map the actions listed in our Acceptance Criteria to code execution in order to determine whether a User Story has been completed or not. Some of the key words we will focus on:
- Feature
    - a high level description of a User Story or group of User Stories
    - feature files should only have one Feature declared: you will run into errors if you have more than one
- Scenario
    - an explicit or direct description of a User Story being implemented
        - this can be a positive or negative scenario
    - you may have multiple scenarios in a feature file

Scenarios (and scenario outlines) can use the following terms to organize their Acceptance Criteria steps. Keep in mind these key words are purely used to indicate new steps to take, which means you can not have duplicate implementations (having a given and when statement with the same text would cause an error). Also, Cucumber does not perform any special actions based on your step keyword used: the expected use case of these keywords is purely for human readability when looking through the feature files and reading test reports.
- Given
    - A starting point and/or precondition for executing the Acceptance Criteria
- When
    - An action that must be taken in order to complete the Acceptance Criteria
- Then 
    - the intended outcome of completing the Acceptance Criteria
    - "Then" statements should be written as "normative" statements
        - example: Then the user "should" be redirected to the puppy homepage
- And/But
    - either can be substituted for a Given, When, or Then when you have multiple Given, When, or Then statements in a row. Can be used to make reading the steps a little less choppy
- \*
    - a star icon can be used in place of any of the step key words

A few other keywords to keep in mind to make organization and automation easier:
- Scenario Outline
    - this keyword is used in conjunction with the "Examples" keyword to make parameterized Scenarios
    - similar to regular scenarios, you can have multiple scenario outlines
- Examples
    - this keyword is used to indicate that the following information is parameterized information for a Scenario Outline
    - you can have unique examples tables for each scenario outline you create
- Background
    - Background can be used in a feature any time you have a shared starting condition between your scenarios (one or more shared "Given" statement)
    - this should be declared before any scenarios
- Rule
    - a relatively new keyword, it can be used instead of scenario to indicate what requirement is being tested
    - can be useful if you are not working with user stories that fit neatly into scenarios
    - if you use the Rule keyword then individual test cases for the Rule are organized in Example blocks (not Examples)
        - [example from Cucumber documentation](https://cucumber.io/docs/gherkin/reference/#rule)

## Cucumber
Cucumber is a testing framework that allows you to easily create End to End tests that utilize gherkin syntax. This framework can take your acceptance criteria (found in one or more feature files) and link them to test steps you create in test classes (typically placed inside of a steps package). Once you have your steps defined (not implemented) you can then write the code to make sure your acceptance criteria is being fulfilled. What Cucumber does specifically is link your acceptance criteria with the step implementations you create in your test classes.

An example feature file that can be used to generate code steps
```feature
Feature: As a user I should be able to view Wikipedia pages in different languages
  Scenario: As an English user I should be able to view Wikipedia in English
    Given I am on the Wikipedia home page
    When  I click the English link
    Then  I should be on the English home page
  Scenario: As an Spanish user I should be able to view Wikipedia in Spanish
    Given I am on the Wikipedia home page
    When  I click the Spanish link
    Then  I should be on the Spanish home page
  Scenario: As an Italian user I should be able to view Wikipedia in Italian
    Given I am on the Wikipedia home page
    When  I click the Italian link
    Then  I should be on the Italian home page
```

If you have similar steps that need to be executed but with different inputs you can wrap your inputs in quotes to have Cucumber generate a parameterized version of the step. In the example below the "when" and first "and" if each scenario will have a parameterized method generated when you first execute the test
```feature
Feature: Login

Scenario: Valid Login
  Given I am at the login page
  When I type in a username of "user123"
  And I type in a password of "password123"
  And I click the login button
  Then I should be directed to the user profile page

Scenario: Invalid Login
  Given I am at the login page
  When I type in a username of "test123"
  And I type in a password of "pass12345"
  And I click the login button
  Then I should receive a message of "Invalid username and/or password"
```
```cli 
...
@When("I type in a username of {string}")
public void i_type_in_a_username_of(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
...
@When("I type in a password of {string}")
public void i_type_in_a_password_of(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
...
```

If you are providing the parameters in a scenario outline you can combine the examples data reference with quote marks to have Cucumber auto provide the data values you want to use
```feature
Scenario Outline: valid users should be able to log in
    Given   the user is on the login page
    When    the user enters "<username>"
    When    the user enters "<password>"
    Then    the user should receive "<result>" message

Examples
|username|password|result|
|valid   |valid   |success|
|invalid |valid   |failure|
etc.
```
leave off the quotation marks if using a non-string type

To generate methods associated with your steps you have a few options:
- if you are using a cucumber/gherkin plugin in your IDE you can execute the feature file directly to have Cucumber generate the steps for you
- you can execute your Test Runner class (assuming you told it where the feature files are located) and have Cucumber generate the steps for you
- you can execute the the "test" or "verify" maven commands to trigger your tests and have Cucumber generate the steps for you
    - To make Cucumber generate your code steps via maven from the terminal your working directory for the terminal needs to be the root folder of the application, or the command will not work properly.
```java
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikiLinksSteps {

    @Given("I am on the Wikipedia home page")
    public void i_am_on_the_wikipedia_home_page() {
        // you write code here to simulate a user's actions
    }
    @When("I click the English link")
    public void i_click_the_english_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the English home page")
    public void i_should_be_on_the_english_home_page() {
        // you write code here to simulate a user's actions
    }

    @When("I click the Spanish link")
    public void i_click_the_spanish_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the Spanish home page")
    public void i_should_be_on_the_spanish_home_page() {
        // you write code here to simulate a user's actions
    }

    @When("I click the Italian link")
    public void i_click_the_italian_link() {
        // you write code here to simulate a user's actions
    }
    @Then("I should be on the Italian home page")
    public void i_should_be_on_the_italian_home_page() {
        // you write code here to simulate a user's actions
    }

}
```
Cucumber takes the acceptance criteria above and links it to the steps defined above. **NOTE** you do not need to localize your step methods: they can be defined in one more multiple classes as long as Cucumber is provided information about where to look to find these methods (how do do this is shown in the next section)

In order to centralize your control over your End to End testing a test runner class can be used. This class is where you will initialize and destroy all shared resources needed for your tests. 

```java
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class) // this sets Cucumber as the framework to run our tests
@CucumberOptions(
        /*
            features: this determines which feature file/s will be used
            glue: this tells Cucumber where the step implementations are. Direct it to a package or multiple classes
         */
        features = "classpath:features",
        glue = "com.revature.steps"
)
public class TestRunner {

    /*
        The WebDriver field below is necessary for interacting with webpages: it has nothing to do inherently with Cucumber, but you will need it to make use of Selenium
    */
    public static WebDriver driver;


    @BeforeClass
    public static void setup(){
        // use the lines below to set your driver configuration manually, if using Selenium version 3.* or older
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); // this tells Java what kind of driver you are using, and where it is located
        driver = new ChromeDriver(); // this initializes the value of the driver field you created above
    }

    // don't forget to quit your driver when you are done
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}

```

Note in the above: All Cucumber has done is link the feature file steps with the Java code steps by using the TestRunner class: you as the tester must provide the means of actually implementing the steps. I skipped ahead a bit and added the Driver field to the TestRunner class already: Selenium will make use of it to interact with the webpage.