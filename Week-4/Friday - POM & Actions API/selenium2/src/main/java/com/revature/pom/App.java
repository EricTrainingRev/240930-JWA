package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            WikiHome wikiHome = new WikiHome(driver);
            // by using the pom design pattern our code is much easier to read/understand
            wikiHome.goToWikipedia();
            wikiHome.clickEnglishLink();
            System.out.println(wikiHome.validateOnCorrectPage("Wikipedia, the free encyclopedia"));

            wikiHome.goToWikipedia();
            wikiHome.enterSearchTerm("puppy");
            wikiHome.clickSearchButton();
            System.out.println(wikiHome.validateOnCorrectPage("Puppy - Wikipedia"));
        } finally {
            if(driver != null){
                driver.quit();
            }
        }

    }
}
