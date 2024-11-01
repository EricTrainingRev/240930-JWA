package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EnglishSteps {

    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_Wikipedia_home_page() {
        // Opens the main Wikipedia page
        TestRunner.wikiHome.goToWikiHome();
    }

    @When("The User clicks the English link")
    public void the_User_clicks_the_English_link() {
        // clicks the English wiki link
        TestRunner.wikiHome.clickEnglishLink();
    }

    @Then("The User should be redirected to the English Wikipedia Homepage")
    public void the_User_should_be_redirected_to_the_English_Wikipedia_Homepage() {
        // we validate the page changed correctly by checking the title
        // Assert is provided by Junit, if the assertion fails an exception is thrown, and we know
        // the expected condition was not achieved
        Assert.assertEquals("Wikipedia, the free encyclopedia", TestRunner.driver.getTitle());
    }
}
