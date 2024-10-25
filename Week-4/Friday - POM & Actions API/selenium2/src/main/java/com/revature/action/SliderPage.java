package com.revature.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage {
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement currentValueHeader;
    @FindBy(tagName = "input")
    WebElement slider;

    public SliderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSliderPage(){
        driver.get("C:\\Users\\EricSuminski\\Desktop\\240930-JWA\\Week-4\\Friday - POM & Actions API\\selenium2\\src\\main\\resources\\slider.html");
    }

    public void clickAndDragSlider(){
        slider.click();
    }

    public String getHeaderText(){
        return currentValueHeader.getText();
    }
}
