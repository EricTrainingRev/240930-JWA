package com.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps {
    @Given("Some shared starting point")
    public void some_shared_starting_point() {
        System.out.println("Some shared starting point executed");
    }

    @When("Action one happens")
    public void action_one_happens() {
        System.out.println("Action one");
    }

    @Then("Result one Should happen")
    public void result_one_Should_happen() {
        System.out.println("Expected result one");
    }

    @When("Action two happens")
    public void action_two_happens() {
        System.out.println("Action two");
    }

    @Then("Result two should happen")
    public void result_two_should_happen() {
        System.out.println("Expected result two");
    }
}
