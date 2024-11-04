package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id = "usernameInput")
    private WebElement registrationUsernameInput;

    @FindBy(id = "passwordInput")
    private WebElement registrationPasswordInput;

    @FindBy(xpath = "//form/input[3]")
    private WebElement registerButton;

    // these pom constructors are basically the same, consider defining the constructor in a parent class
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        registrationUsernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        registrationPasswordInput.sendKeys(password);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
}
