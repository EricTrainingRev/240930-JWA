package com.revature;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class NavigationAndErrorHandlingAndScreenshots {
    public static void main(String[] args) {

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            // set up an implicit wait since we are hopping between pages quickly
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            // you can resize your browser if you need to simulate full screen, or minimize the browser
            driver.manage().window().maximize(); // fullscreen not working for some reason
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

            /*
                At the time of this demo, Wikipedia is doing their donation drive, so a pop up is currently
                preventing the driver from interacting with the Spanish link. We can write some code
                to minimize the pop up if it is present
             */
            List<WebElement> overlayButton = driver.findElements(By.className("frb-header-minimize"));
            if(overlayButton.size() != 0){
                overlayButton.get(0).click();
            }
            By spanishLinkSelector = By.id("js-link-box-es");
            WebElement spanishLink = driver.findElement(spanishLinkSelector);
            spanishLink.click();

            String expectedSpanishTitle = "Wikipedia, la enciclopedia libre";
            System.out.println(driver.getTitle().equals(expectedSpanishTitle));


        // Element click intercepted is a subclass of ElementNotInteractable, so we only need to catch the later
        } catch (ElementNotInteractableException e){
            takeScreenshot(driver);
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }

    // using helper method to take screenshot to make the logic a little easier to understand
    public static void takeScreenshot(WebDriver driver){
        try{
            // to better understand the state of the page when things go wrong we can take a screenshot

            // we can cast our driver as a TakesScreenshot object to get the screenshot data of the browser
            File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // because we need unique names for our screenshots without colons we can iterate through local date data and replace colons with dashes
            StringBuilder dateFormatter = new StringBuilder(LocalDateTime.now().toString());
            for(int index = 0; index < dateFormatter.length(); index++){
                if (dateFormatter.charAt(index) == ':'){
                    dateFormatter.replace(index,index+1,"-");
                }
            }
            // next we determine the path where we want to save the screenshot
            // we can append the current time data to the screenshot name to make it unique
            Path screenshotDestination = Paths.get(String.format("src/main/resources/exception-screenshot-%s.jpeg", dateFormatter.toString()));
            // finally we use the Files class to save the screenshot data to our given path location
            // NOTE: creating screenshot will fail if the file already exists: either delete the old photo or use something like a time stamp to make your new one unique
            Files.copy(fileData.toPath(), screenshotDestination);
        } catch (IOException e){
            System.out.println("Could not take a screenshot");
            e.printStackTrace();
        }

    }
}
