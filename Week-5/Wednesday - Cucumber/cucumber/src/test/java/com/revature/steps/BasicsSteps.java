package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicsSteps {

    @Given("Some first step")
    public void some_first_step() {
        System.out.println("Some first step");
    }

    @When("Some action happens")
    public void some_action_happens() {
        System.out.println("Some action happens");
    }
    @Then("Some expected result")
    public void some_expected_result() {
        System.out.println("Some expected result");
    }

}
