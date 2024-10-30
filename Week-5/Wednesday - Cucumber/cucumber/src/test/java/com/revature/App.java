package com.revature;

import io.cucumber.core.cli.Main;

/*
    Cucumber is a testing framework that maps acceptance criteria written in Gherkin syntax to Java
    methods that can be executed sequentially to automate the testing of a scenario/rule that has
    associated acceptance criteria

    There are a few ways you can run your Cucumber test suite:
    - The Cucumber library has a Main class in the "io.cucumber.core.cli" package that can be executed
      in order to run your tests. This requires providing multiple command line arguments to the class
      so that it knows where your code and feature files are located, and if you want to format the
      output of your tests at all you must provide that information as well. This can be clunky, but
      if using Cucumber alone it is necessary. If using Intellij you can use the Cucumber for Java and
      Gherkin plugins JetBrains provides to make this process easier

    - You can also wrap the Cucumber Main class with your own, and reference the Main.main method in your
      wrapper class main method
 */
public class App {
    public static void main(String[] args) {
        Main.main(
                new String[]{"-g","com.revature.steps"}
        );
    }
}
