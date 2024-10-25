package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    The Page Object Model (POM) design pattern is meant to help
    developers represent the web pages they need automated in
    their Java code so they can easily and repeatably interact
    with the page.

    This design pattern is basically just a regular class, but
    we let the PageFactory class handle element location and
    instantiation for us
*/
public class WikiHome {

    private WebDriver driver;

    /*
        In order for the page factory (see constructor below) to know what fields it needs to initialize
        we use the @FindBy annotation. We provide a locator strategy and the value for that strategy,
        and the PageFactory handles the logic of actually locating and creating a WebElement object
        for us, allowing us to focus on just writing implementation code
     */
    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    @FindBy(className = "frb-conversation-close")
    private WebElement popupCloseDiv;
    @FindBy(css = "button[aria-label='minimize']")
    private WebElement popupCloseButton;

    @FindBy(name = "search")
    private WebElement searchBar;

    // we can use full xpath
    // @FindBy(xpath = "/html/body/main/div[2]/form/fieldset/button")
    // or we can use relative xpath
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(className = "banner__close")
    private WebElement bannerButton;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        /*
            Selenium provides a helper class called the PageFactory
            that we can use to abstract away the instantiation of
            the web elements we want to use in our POM. the
            "initElements" method requires two arguments:
            - a driver to find the elements
            - a reference to the object that will have its WebElements
              initialized
         */
        PageFactory.initElements(driver,this);
    }

    public void goToWikipedia(){
        driver.get("https://www.wikipedia.org/");
    }

    public void clickEnglishLink(){
        englishLink.click();
    }

    public boolean validateOnCorrectPage(String title){
        return driver.getTitle().equals(title);
    }

    public void enterSearchTerm(String input){
        if (popupCloseDiv.isDisplayed()){
            popupCloseDiv.click();
        } else if(popupCloseButton.isDisplayed()){
            popupCloseButton.click();
        }
        if (bannerButton.isDisplayed()){
            bannerButton.click();
        }
        searchBar.sendKeys(input);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

}
