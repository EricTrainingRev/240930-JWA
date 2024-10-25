package com.revature.action;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void clickAndDragSlider(int targetValue){
        /*
            In order for us to accurately simulate clicking and sliding the input to the correct
            position we need to know where the slider element is on the web page and what its
            dimensions are. We can get this information from the WebElement directly using the
            "getLocation" method and the "getSize" method
         */
        // getLocation returns the top left pixel position of the element in the "HTML Content Render Pane"
        // in (x, y) position format
        Point topLeftPosition = slider.getLocation();
        // getSize returns the dimensions of the element (how long(x length) and how tall(y length) it is)
        Dimension elementSize = slider.getSize();
        /*
            The code below is an example of how to dynamically determine the slider movement range for
            each possible value in the slider
         */
        // first we get the width of the element
        int elementWidth = elementSize.getWidth();
        // next we get the minimum value of the slider
        int minSliderValue = Integer.parseInt(slider.getAttribute("min"));
        // depending on the minimum value, if it allows for 0 or for negative numbers you
        // may need to accommodate by setting that value to 1 if it is a 0 or getting the
        /*
            // absolute value of the minimum if it is a negative number
            if(minSliderValue == 0){
                minSliderValue++;
            }
            // if the min value was a negative number
            if(minSliderValue < 0){
                minSliderValue = Math.abs(minSliderValue) + 1;
            }
        */
        // since we already know the min is 0 and the step increment is 1 we can set the min value to 1 for our next step
        minSliderValue++;
        // get the max value
        int maxSliderValue = Integer.parseInt(slider.getAttribute("max"));
        // determine total possible values, make sure to divide number by step value if it is not 1
        int stepValue = Integer.parseInt(slider.getAttribute("step"));
        int totalPossibleValues = (minSliderValue + maxSliderValue) / stepValue;
        // now you can determine your move increment
        // TODO: +1 does not feel very elegant, there is probably a Math method to accomplish the rounding
        int moveIncrementDistance = elementWidth/totalPossibleValues+1;
        /*
            The default size of the element has a width of 129: there are 11 supported values, so we can
            divide the width of the element by the number of possible values to determine the distance
            we need to move the slider in order to get our desired value: 129/11 = ~11.7 which we can
            round to 12 for ease of use, or using the dynamic determination code above, go with 11

            Now that we know the increment to move for each value of the slider, we just multiply that
            value by whatever number we want to set the slider to: 11 * 6 = 66 which we can tell Selenium
            to do via the Actions API
         */

        /*
            Now that we know where the element is, its dimensions, and the distance to move the
            slider to get the value we want, we can finally use the Action API to tell Selenium
            how to do our actions. For this we will use the Actions class: this class uses the
            builder design pattern in order to allow you to chain the actions you want to perform
            together, and then the Actions class will either build the action chain and execute
            them via Selenium, or you can save the action chain and call it at a later time
         */
        new Actions(driver)
                // step 1: move the mouse to the start of the slider element
                /*
                    We can use the topLeftPosition variable to get our x and y coordinates. If we are
                    concerned the mouse will not actually click the slider at the top left we can
                    use the elementSize variable to calculate the distance needed to move half way down
                    the element so we are click the center of the Y axis, which should make sure we actually
                    click on the slider

                    note that in the browsers, the top left corner of the view Content Render Pane is position
                    x = 0, y = 0. The farther to the right you go the larger x becomes, the farther down the
                    view you go the larger y becomes, hence why we add the y values below
                 */
                .moveToLocation(topLeftPosition.getX(), topLeftPosition.getY() + elementSize.getHeight()/2)
                // once our mouse is in the correct location we need to tell Selenium to click and hold the slider button
                .clickAndHold()
                // once the mouse is clicked and held we need to tell Selenium to move to the target value position
                // which we have already calculated above
                .moveByOffset(moveIncrementDistance*targetValue, 0)
                // finally, we need to release the mouse so we don't accidentally change the slider value with later actions
                .release()
                // use "build" if you want to save the action chain in an Action object to use later
                // use "perform" if you want to build and execute the action chain right away
                .perform();

    }

    public String getHeaderText(){
        return currentValueHeader.getText();
    }
}
