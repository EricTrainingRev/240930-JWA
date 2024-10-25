# Selenium

### Introduction

Selenium is an open source project for web browser automation. This means that Selenium consists of software that can control a web browser and perform actions like any human user could - for example, navigating to a website, clicking buttons, and filling out forms. Selenium WebDriver is the core of Selenium which provides an API in many different languages for programmers to write code to manipulate the browser. We will be looking at the Java API for Selenium WebDriver (Selenium WebDriver supports multiple programming languages, not just Java)

There are a few use cases for Selenium:
* Automated scripts, for example to schedule tedious tasks like filling out a timesheet each week
* Web scraping - gathering information from website front-ends without needing back-end API integrations
* Test automation - this is the main use case, and can be deployed in DevOps pipelines to validate end to end features
* Performance testing - measuring the responsiveness of a webapp accurately and consistently

### Configuring Selenium

To get started, first include the following dependency in your `pom.xml` file (assuming you're using Maven):

```xml
<!-- this version assumes you are using JDK 8. if using a newer JDK version 4.* is easier to set up -->
<dependency>
  <groupId>org.seleniumhq.selenium</groupId>
  <artifactId>selenium-java</artifactId>
  <version>3.141.59</version>
</dependency>

<!-- NOTE: this dependency can be used to automate driver management -->
<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.2.3</version>
</dependency>
```

You can find the most updated version [here](https://www.selenium.dev/maven/) as well.

Next, we will need to include the driver of the browser we want to use if using a version of Selenium older than V 4. Selenium uses this executable to interact with the browser instance.

Use one of the links below to download your particular driver, and include it in the `src/main/resources` folder:
* [Chrome](https://chromedriver.chromium.org/downloads)
* [Firefox](https://github.com/mozilla/geckodriver/releases)
* [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

### Getting Started

Once configured, you can start using Selenium's API. Below are some of the main classes and interfaces we will need to use:
* `WebDriver` - to control the browser window itself
  * `WebDriver.findElementsBy()` method to query the DOM
* `By` - how should we query the DOM?
  * id, className, tagName, CSS selector, xpath, link text, partial link text
* `WebElement` - represents an HTML element
* `WebDriverWait` - for performing explicit waits
* `ExpectedCondition` - add dynamic waiting for certain conditions

To create a browser instance and go to google.com we can do the following:

```java
// start here if using Selenium V3 or older

// option 1: manually configure the driver resource
File path = new File("src/main/resources/chromedriver.exe");
System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());

// option 2: use the webdriver manager dependency to automatically configure a driver for you
WebDrivermanager.chromedriver().setup();

// start here if using Selenium V4 or newer
WebDriver driver = new ChromeDriver();
driver.get("https://google.com");
driver.quit(); // make sure to always quit the driver when finished. try/finally works well for this
```
**NOTE**: different implementations of the WebDriver (such as ChromeDriver or EdgeDriver) have different Option classes that allow you to configure the settings for the browser that Selenium uses for automation. For instance, if you wanted to verify that you can navigate a website without needing cookies active you could start the browser in incognito mode to prevent accidentally using cookie data. Depending on the browser you are using the flags you will add to the option object will be different
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--incognito");
WebDriver driver = new ChromeDriver(options);
```
Note that if you need to open a browser using a profile (common when testing in enterprise virtual machines) using your browsers option class is how you would activate the profile

Now, what if we want to find elements on the page and manipulate them?

```java
WebElement myElement = driver.findElement(By.id('someId'));
myElement.click(); // just like a human would click a button!
myElement.sendKeys("Hello, world!"); // if this is an input, we can send text to it
List<WebElement> allDivs = myElement.findElements(By.tagName("div")); // we can search within elements too!
// now we can even print out the text inside each HTML element
for (WebElement div : allDivs) {
  System.out.println(div.getText());
}
```
Selenium supports 8 Locator strategies by default:
|Locator|Description|
|-----------|-----------|
|class name|	Locates elements whose class name contains the search value (compound class names are not permitted)|
|css selector|	Locates elements matching a CSS selector|
|id|	Locates elements whose ID attribute matches the search value|
|name|	Locates elements whose NAME attribute matches the search value|
|link text|	Locates anchor elements whose visible text matches the search value|
|partial link text|	Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.|
|tag name|	Locates elements whose tag name matches the search value|
|xpath|	Locates elements matching an XPath expression|

## .navigate()
Driver objects have access to a method called "navigate" that can be used to perform basic navigation actions in the browser. Note the main difference between using the get method and navigate.to is the former does not save session data (cookies).
```java
driver.navigate().back(); // simulates clicking the back button
driver.navigate().forward(); // simulates clicking the forward button
driver.navigate().refresh(); // simulates clicking the refresh button

driver.navigate().to("url"); // same as driver.get("url"), except it saves session data
```


What happens if we try to query for an element, but that element does not exist on the page? Selenium will throw a `NoSuchElementException`. There is also a chance that we have a reference to an element that no longer exists. If we try to use it, we will get a `StaleElementException` as shown below.

```java
WebElement myElement = driver.findElement(By.id("someId"));
driver.get("http://someothersite.com");
myElement.click(); // StaleElementException thrown here!
```

Sometimes we will get a `NoSuchElementException` when we try to query for an element before it gets loaded on the DOM. In these cases, we would like
to **wait for the element to appear**. There are three ways of approaching this:
* Implicit waits
* Explicit waits
* Fluent waits

Implicit waits are a global configuration on the `WebDriver` object and apply every time the DOM is queried. 
```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().wait(Duration.ofSeconds(1)); // this tells the driver to wait up to one second for elements to be found on the page
```

Explicit waits apply individually and adjust the waiting time explicitly and dynamically at regular intervals. For example, if it usually takes 3 seconds for an element to load, you can use an explicit wait to tell Selenium to pause execution while waiting for that element to load. This allows you to avoid adjusting your implicit wait to accommodate an outlier element that takes a long time to load, but it also allows you to wait for many other situations (alert present/gone, title text, element hidden, etc.) You should **ALWAYS use explicit waits** (don't use Thread.sleep()). They are not only more performant but have well documented and defined behavior and work with a wide variety of conditions.

Below is an example of using an explicit wait to wait until the element is visible on the page.

```java
WebElement invalidElement = driver.findElement(By.id("someId"));
invalidElement.click(); // NoSuchElementException!
WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(5))
   .until(ExpectedConditions.elementToBeVisible(By.id("someId")));
myElement.click(); // works now!
```

There are many other "expected conditions" you can use from the `ExpectedConditions` class, which you can find in the API documentation. A few use cases are listed below:
* Waiting for an element to exist, be invisible, be clickable, to contain certain text
* Waiting for the URL or title of the page to match a pattern
* Waiting for a certain number of matched elements to appear
* Combining wait conditions with logical `.and()` and `.or()` methods


**Fluent waits** take Explicit Waits a couple steps further.
* we still have the ability to set the time we are waiting
* we still have the ability to provide some Expected Condition
* we also have: 
  * the ability to control the frequency at which we are polling the page
  * the ability to ignore any exceptions that might be thrown

```java
new FluentWait<WebDriver>(driver)
    .withTimeout(Duration.ofSeconds(10)) // how long in total to wait for the page/DOM to load
    .pollingEvery(Duration.ofSecond(2)) // during those 10 seconds - we are looking at the DOM every 2 seconds
    .ignoring(ElementNotInteractableException.class) // if any exception occurs - we ignore it and keep polling
    .until(ExpectedConditions.visibilityOf(someWebElement)); // specifies what condition to be looking for
```

### xpath
xpath is a subject interviewers like to ask questions about, so you will want to dedicate time to studying how to make use of this resource. The [xpath cheatsheet](https://devhints.io/xpath) is an excellent resource for learning how to use this tool, and it includes a link to a web page that allows for practicing using it as well.

### Page Object Model Pattern

Imagine you are trying to automate a single page application. There are multiple views that you need to interact with and many elements to query for. Navigating to pages and repeatedly querying the DOM can result in messy, unorganized code. A simple design pattern to organize your code around is called the **Page Object Model**. In this pattern, you create one class for every page you are interacting with. The fields of this class are the elements on the page you perform actions on. This allows for both *encapsulation of the state and behavior of each page* as well as *abstracting lower level code away*. Selenium has support for this pattern through the `@FindBy` annotation and the `PageFactory` class. Let's view an example below.

```java
public class CheckoutPage {
  WebDriver driver;

  @FindBy(className = "item")
  private List<WebElement> items;

  @FindBy(id = "purchase")
  private WebElement buyItemsBtn;

  public MyHomePage(WebDriver dr) {
    this.driver = dr;
    PageFactory.initElements(dr, this); // we need this line to tell Selenium to instantiate the fields in our class
  }

  public WebElement getFirstItemName() {
    return items.get(0).getText();
  }

  public void buyAllItems() {
    buyItemsBtn.click();
  }
}
```

The example above represents a simple checkout page of an ecommerce site. There are two elements we are about - divs with the "item" class and the button to purchase the items. Notice how we encapsulate the fields and provide public methods to manipulate those fields in semantically meaningful ways. Also, other areas of the application can now simply call `new CheckoutPage(driver).buyAllItems()` instead of worrying about querying for elements and clicking them. Therefore this pattern lets us properly use abstraction when writing automated tests.

## Actions API
Selenium WebDriver makes use of HTTP to interact with the browser: for most interactions this is fine, but sometimes you need a more true-to-the-user way of interacting with the browser (drag and drop, moving a slider via click and drag, drawing in a canvas, etc.). In these scenarios Selenium has the Actions API: using the Actions class you can chain together a collection of commands that give you more fine-tune control over the user mouse, keyboard, wheel, and pen if one is connected. These actions you chain together can then be executed immediately or saved in an Action object for future use

```java
// example taken from lecture demo
            new Actions(driver)
                    .moveToLocation(sliderTopLeft.getX(),sliderTopLeft.getY() + sliderWidthAndHeight.getHeight()/2 )
                    .clickAndHold()
                    .moveByOffset(60,0)
                    .release()
                    .perform();
```

## Screenshot functionality
Selenium has the ability to take a screenshot of the browser render pane and save the data to a File object in your Java code. This can be particularly useful when using Selenium for testing purposes to have a visual of what the webpage you are interacting with looks like when things go wrong, and is a better alternate than trying to add clunky sleep calls in your test code
```java
// TakesScreenshot is an interface that implements getScreenshotAs, so we cast the WebDriver to it in order to gain access to the method
File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// remember that you make a Path (singular) object via Paths (plural) get() method
Path screenshotDestination = Paths.get("src/main/resources/filename.jpeg"); // can choose an extension of your choice
// Use the Files (plural) class to copy the file data to your destination
Files.copy(fileData.toPath(), screenshotDestination);
```

## Selenium IDE and Selenium Grid
Selenium IDE is a plugin for browsers (Chrome and Firefox have native compatibility) that allows for recording user input and generating Selenium commands for the actions taken. It can be used to help build test cases for automated test suites quickly, and through the use of extra plugins it can be a robust automation suite directly accessed in the browser.

Selenium Grid is a tool that "allows the execution of WebDriver scripts on remote machines by routing commands sent by the client to remote browser instances." It allows for running your Selenium code on multiple machines and in multiple browsers simultaneously. This is a useful tool for testing that a web application behaves as intended across operating systems and web browsers

## JavaScript Executor
Selenium has the ability to execute JavaScript for you in the browser during automation. For testing purposes it is generally better to avoid using the executor during automated test steps (typical users will not write and execute JavaScript during their normal use of a web application.... usually) but it can be a useful resource for debugging faulty tests and aggregating data for defect reports. However, to get the most out of the tool you need to have a good understanding of how JavaScript works and how to interact with the DOM via JavaScript. It is a worthwhile tool too explore if you know JavaScript or want to log more data in your defect reports, but for general training purposes it is not necessary to use.
