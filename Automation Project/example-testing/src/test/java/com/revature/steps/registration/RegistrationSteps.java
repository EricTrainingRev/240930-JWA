package com.revature.steps.registration;

import com.revature.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationSteps {

    @When("The user enters the username {string}")
    public void the_user_enters_the_username(String username) {
        TestRunner.registrationPage.enterUsername(username);
    }

    @When("The user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        TestRunner.registrationPage.enterPassword(password);
    }

    @When("The user clicks the register button")
    public void the_user_clicks_the_register_button() {
        TestRunner.registrationPage.clickRegisterButton();
    }

    @Then("Then an alert should appear saying {string} for {string}")
    public void then(String message, String username) {
        // here we tell the driver to wait up to 2 seconds for the alert before continuing
        TestRunner.alertWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        // if one of these assert statements fails then the methods execution stops, so we need to make sure the alert is closed
        try{
            if(message.equals("User created")){
                Assert.assertEquals("Account created successfully with username \"" + username + "\"", alertMessage);
            } else if (message.equals("User not created")) {
                Assert.assertEquals("Account creation failed with username \"" + username + "\"", alertMessage);
            } else{
                Assert.fail("Incorrect alert message produced: actual message: " + alertMessage );
            }
        } finally{
            alert.accept();
            // here we tell the driver to wait up to 2 seconds for the alert to be gone before continuing
            TestRunner.alertWait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        }


    }

    @Then("The {string}")
    public void the(String redirectionResult) {
        if(redirectionResult.equals("User redirected to login page")){
            Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
        } else {
            Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
        }
    }
}
