package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {

    private WebDriver driver;

    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEnglishLink(){
        englishLink.click();
    }

    public void goToWikiHome(){
        driver.get("https://www.wikipedia.org/");
    }

}
