package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {

    public static void main(String[] args) {

        /*
            In order for us to use Selenium we need to create a WebDriver object. This object is
            used to facilitate all our actions in the browser
         */

        // make sure to specify WebDriver as your type, but initialize a specific browser driver object

        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            /*
                Something to be aware of when working with Selenium is, due to the way in which the
                driver interacts with the browser (http requests), interactions on the web page happen
                very quickly. The Driver is able to detect and interact with resources usually before
                the content is rendered in the browser. This can make it look like content does not
                load or that content is missing, but as long as your automation code does not throw
                an exception, you can be confident the content you wanted to interact with was available
                and Selenium was able to interact with it

                Keep this in mind when building your automation apps: you should not expect to be able
                to follow the actions Selenium takes when it is automating actions. You will have to write
                code to tell Selenium to let you know if something does not work as expected
             */

            // the "get" method is used to open a web page in the browser
            driver.get("https://www.wikipedia.org/");

            /*
                When you need to interact with elements on a web page you have to tell Selenium how
                to find the element/s you are looking for. Selenium makes use of CSS selectors much
                like how a browser uses them to apply styling. In our case, the selector is used to tell
                Selenium what element/s we need to interact with. The "By" class is used to tell the
                driver what selector and associated value we want to use to find our web element/s
             */

            // this By selector is for finding the english home page link on wikipedia
            By idSelector = By.id("js-link-box-en");
            // we use the driver "findElement" method and pass the By selector as an argument to return the element
            WebElement englishLink = driver.findElement(idSelector);

            // all WebElements have the "click" method, which simulates a user clicking on the element
            englishLink.click();

            // a simple way of validating you have changed to a new page correctly is to check the title
            String expectedTitle = "Wikipedia, the free encyclopedia";

            // "getTitle" will return the title of the current page
            System.out.println(driver.getTitle().equals(expectedTitle));

        } finally {
            if(driver != null){
                // make sure you use the "quit" method when you are done with the app, or the driver will remain active
                driver.quit();
            }
        }


    }

}
