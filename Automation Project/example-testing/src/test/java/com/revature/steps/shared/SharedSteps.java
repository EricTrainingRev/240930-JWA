package com.revature.steps.shared;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SharedSteps {
    // starting step for basically every scenario
    @Given("The user is on the login page at url {string}")
    public void the_user_is_on_the_login_page_at_url(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    // shared by Registration tests
    @When("The user clicks the registration button")
    public void the_user_clicks_the_registration_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
