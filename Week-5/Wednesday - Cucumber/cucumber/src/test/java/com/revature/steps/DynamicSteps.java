package com.revature.steps;

import io.cucumber.java.en.Given;

public class DynamicSteps {
    /*
        {string} is a reference to the type of data that
        Cucumber is providing dynamically to our step method.
        By default, Cucumber will try to provide whatever the data
        is as a String value.
     */
    @Given("{string} is provided")
    public void is_provided(String word) {
        System.out.println(word + " was the provided String value");
    }
}
