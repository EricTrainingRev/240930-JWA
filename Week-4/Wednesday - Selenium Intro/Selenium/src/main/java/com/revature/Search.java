package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            /*
                In this example we will search for the puppy article on Wikipedia using the search
                bar on the main page
             */
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
            // there are two elements we want to find: the search bar and the search button
            By searchBarSelector = By.name("search");
            By searchButtonSelector = By.className("pure-button");

            WebElement searchBar = driver.findElement(searchBarSelector);
            WebElement searchButton = driver.findElement(searchButtonSelector);

            // we now need Selenium to type "puppy" in to the search bar
            searchBar.sendKeys("puppy");
            // once the text is sent to the search bar we can click the search button
            searchButton.click();

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
