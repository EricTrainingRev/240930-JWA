package com.revature.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Anytime you need to simulate a user action that goes beyond the basics of clicking things and entering
    text in the browser, you need a tool like the Actions API. This is a library of tools that allows for
    the driver to perform more intricate or complex tasks than it normally is capable of doing. In particular,
    the Actions API allows for the driver to simulate user actions with the following tools:
    - mouse/pen
    - keyboard
    - mouse wheel

    This is often required when you want to automate actions such as clicking and dragging, clicking
    key inputs without associating those inputs with a specific web element, or if you need to scroll
    the page in order to find a web element to interact with
 */
public class ActionsAPI {

    /*
        This example uses the "slider.html" file in the resources directory

        The goal of this example is to use Selenium and the Actions API
        to set the slider value to 6 and validate the header has the value
        of 6 as its text content
     */
    public static void main(String[] args) {
        // step 1: initialize web driver and pom
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            SliderPage sliderPage = new SliderPage(driver);

            // step 2: open the slider web page
            sliderPage.openSliderPage();

            // step 3: click and drag the slider to the 6 position
            sliderPage.clickAndDragSlider(6);

            // step 4: validate the header says 6
            System.out.println(sliderPage.getHeaderText());
        } finally {
            // make sure to close the driver
            if(driver != null){
                driver.quit();
            }
        }




    }

}
