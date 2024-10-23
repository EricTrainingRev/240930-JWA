package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void main(String[] args) {
        /*
            Because Selenium is typically able to work faster than your browser you will often
            need to tell Selenium to wait for something to happen, or some element to be present,
            before it continues with execution. You have two primary ways of telling Selenium to
            wait: Explicit and Implicit waits
         */

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            /*
                Due to our inability to control latency when using the browser it is oftentimes a good
                idea to set up an "implicit" wait for your driver. This tells the driver to wait X amount
                of time before throwing an exception for being unable to interact with a web page

                This kind of wait is universal: Selenium will apply the given wait time for every web element
                interaction you create. This means this particular kind of wait is primarily useful for preventing
                application crashes when you have poor latency or when interacting with a slow web page
             */

            // "implicityWait" requires a Duration object to tell it how long to wait
            // in the example below we tell the driver to wait up to one second for an element to be interactable
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            /*
                Implicit waits are useful for handling slow internet/apps, but they are generic in how they
                work: they specifically tell the Driver to wait for an element to be interactable, and that
                is it. Sometimes you will have elements that are interactable but need to change or be transformed
                in some way. In these instances, you need an Explicit Wait to tell the Driver the specific scenario
                you are waiting for

                To create an Explicit Wait you use the WebDriverWait object
             */

            // this explicit wait is set to wait 3 seconds for some condition
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

            // code taken from Search example
            driver.get("https://www.wikipedia.org/");
            By searchBarSelector = By.name("search");
            By searchButtonSelector = By.className("pure-button");
            WebElement searchBar = driver.findElement(searchBarSelector);
            WebElement searchButton = driver.findElement(searchButtonSelector);
            searchBar.sendKeys("puppy");
            searchButton.click();

            /*
                If we expect the changing of the web page to take some time we can use our Explicit
                Wait in order to tell Selenium to give the browser a moment to actually change pages

                The ExpectedConditions class is used with Explicit Waits to tell Selenium the condition
                that you are waiting for before Selenium continues with its regular actions
             */

            // we can tell Selenium to wait till the title has changed to what we are expecting
            // explicitWait.until(ExpectedConditions.titleIs("Puppy - Wikipedia"));
            // we can inverse the wait and till Selenium to pause until a condition is no longer true
            explicitWait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));

            // finally, we validate we are on the correct page
            String expectedTitle = "Puppy - Wikipedia";

            System.out.println(driver.getTitle().equals(expectedTitle));

        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }

}
