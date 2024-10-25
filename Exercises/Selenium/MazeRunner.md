# MazeRunner

## Objective
Practice navigating and interacting with web elements using the Actions API. The goal is to become proficient in creating page object models and methods to automate web page navigation.

## Description
MazeRunner is an activity designed to enhance your skills in using the Actions API to navigate and interact with elements on a web page. Using the provided maze web pages, you will create a page object model and methods to navigate through the maze. This activity will help you become more comfortable with the Actions API and its practical applications.

## Main Goals
- Practice creating page object models to represent web pages.
- Develop methods to navigate through web page elements using the Actions API.
- Gain proficiency in taking screenshots of the application in action.

## Requirements
- **Create Page Object Model**: Develop a page object model to represent the maze web page.
- **Develop Navigation Methods**: Create methods that your application can use to navigate through the maze.
- **Take Screenshots**: Capture screenshots of the end results of your application in action.

## Instructions

### Setup
1. Download the maze web page resources.
2. Open the maze web pages in your preferred browser.

### Create Page Object Model
1. **Read Instructions**: Carefully read the instructions provided on the maze web page.
2. **Develop Page Object Model**: Create a page object model to represent the maze web page. This model should include elements such as the maze itself, start and end points, and any interactive elements.

### Develop Navigation Methods
1. **Create Navigation Methods**: Develop methods that your application can use to navigate through the maze. These methods should utilize the Actions API to interact with the web page elements.
2. **Test Navigation**: Ensure your navigation methods work correctly by testing them on the maze web page.

### Take Screenshots
1. **Capture End Results**: Once your application successfully navigates the maze, take a screenshot of the end results.
2. **Save Screenshots**: Save the screenshots to verify the effectiveness of your application.

### Example
```java
public class MazePage {
    private WebDriver driver;

    @FindBy(id = "startPoint")
    private WebElement startPoint;

    // Constructor
    public MazePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.init(driver, self);
    }

    // Method to navigate the maze
    public void navigateMaze() {
        // Example actions to navigate the maze
        Actions actions = new Actions(driver);
        actions.moveToElement(startPoint)
        // continue chaining instructions, use helper methods to find helpful data as needed
    }

    // Method to take a screenshot
    public void takeScreenshot(String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("filePath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
