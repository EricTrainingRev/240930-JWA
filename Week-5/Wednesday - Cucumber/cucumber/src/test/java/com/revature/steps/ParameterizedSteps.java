package com.revature.steps;

import io.cucumber.java.en.When;

public class ParameterizedSteps {

    @When("apple is provided")
    public void apple_is_provided() {
        System.out.println("apple method called");
    }

    @When("puppy is provided")
    public void puppy_is_provided() {
        System.out.println("puppy method called");
    }

}
