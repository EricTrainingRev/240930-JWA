package com.revature.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class TypesSteps {

    /*
        If you need to work with non-String types you can use
        the @ParameterType annotation and a method to tell Cucumber
        how to recognize the data that needs to be converted by
        using Regular Expression, and the code that will convert
        the String into whatever data type you need
     */

    // this turns true/false strings into boolean values
    @ParameterType("true|false")
    public Boolean truth(String truth){
        return Boolean.parseBoolean(truth);
    }

    /*
        in order to get your converted type into your steps you
        need to reference the method used to perform the conversion
        in your acceptance criteria

        Keep in mind, if you don't want to have the values dynamically
        provided, you will need a unique step for each element that
        is used in your scenario outline
     */
    @Given("{int} unique data provided")
    public void unique_data_provided(int num) {
        System.out.println(num + 5);
    }

    @Given("What is {truth}")
    public void what_is_true(boolean truth) {
        System.out.println(truth == true);
    }

    @Given("Some {string} input")
    public void some_input(String word) {
        System.out.println(word);
    }


}
