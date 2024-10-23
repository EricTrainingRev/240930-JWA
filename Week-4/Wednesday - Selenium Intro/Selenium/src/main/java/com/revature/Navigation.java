package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Navigation {
    public static void main(String[] args) {

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            // set up an implicit wait since we are hopping between pages quickly
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            // code taken from Basics example
            driver.get("https://www.wikipedia.org/");
            By idSelector = By.id("js-link-box-en");
            WebElement englishLink = driver.findElement(idSelector);
            englishLink.click();
            String expectedTitle = "Wikipedia, the free encyclopedia";
            System.out.println(driver.getTitle().equals(expectedTitle));

            /*
                if you want to simulate a user clicking the back button you can use the "navigate"
                method. There are a few other helpful methods:
                - "back" simulates the user clicking the back button
                - "forward" simulates the user clicking the forward button
                - "refresh" simulates the user clicking the refresh button
                - "to" takes in a url and navigates the browser to the given page
                    - is an alias for get, so practically it is the same as "get"
                    - unlike "get", the "to" method will save cookie data, so when you need to
                      account for cookies use navigate().to() instead of get
             */
            driver.navigate().back();

            By spanishLinkSelector = By.id("js-link-box-es");
            WebElement spanishLink = driver.findElement(spanishLinkSelector);
            spanishLink.click();

            String expectedSpanishTitle = "Wikipedia, la enciclopedia libre";
            System.out.println(driver.getTitle().equals(expectedSpanishTitle));


        } finally {
            if(driver != null){
                driver.quit();
            }
        }

    }
}
