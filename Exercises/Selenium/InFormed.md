# InFormed Activity

## Objective
Automate a series of quirky and challenging forms using Selenium and Java. The goal is to successfully submit each form while handling various edge cases.

## Description
inFormed is a series of forms designed to test your automation skills. Each form has unique quirks and challenges that require creative solutions. A timer will display how long it took to submit each form, adding an element of competition and urgency.

## Main Goals
- Practice coding Selenium automation using Java.
- Handle edge cases in Selenium, such as browser resizing and dynamic content.

## Requirements
- **Automate Form Submission**: Write Selenium applications to automate the submission of each form.
- **Handle Edge Cases**: Ensure your scripts can handle various edge cases, including browser resizing and dynamic content.

## Instructions

### Setup
1. Download the files in the inFormed directory.
2. Set up your development environment with Java and Selenium.

### Automate Each Form
1. **Create a Page Object Model (POM)**: For each web page, create a POM to encapsulate the elements and actions.
2. **Write Selenium Scripts**: Automate the form submission process using Java and Selenium.
3. **Handle Edge Cases**: Ensure your applications can handle edge cases such as browser resizing, dynamic content, and unexpected pop-ups.

### Example Code
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    WebDriver driver;

    @FindBy(id = "inputField")
    WebElement inputField;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String input) {
        inputField.sendKeys(input);
        submitButton.click();
    }

   // you can simplify your code if you create a Main class to execute your code from
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///path/to/form.html");

        FormPage formPage = new FormPage(driver);
        formPage.fillForm("Test Input");

        driver.quit();
    }
}
```