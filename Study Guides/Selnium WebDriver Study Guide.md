# Selenium WebDriver Study Guide

## Orientation

### Introduction & Web Elements
**Selenium** is an open source project for web browser automation. This means that **Selenium** consists of software that can control a web browser and perform actions like any human user could - for example, navigating to a website, clicking buttons, and filling out forms. **Selenium WebDriver** is the core of **Selenium** which provides an API in many different languages for programmers to write code to manipulate the browser. We will be looking at the Java API for **Selenium WebDriver** (Selenium WebDriver supports multiple programming languages, not just Java)

There are a few use cases for **Selenium**:
* Automated scripts, for example to schedule tedious tasks like filling out a timesheet each week
* Web scraping - gathering information from website front-ends without needing back-end API integrations
* Test automation - this is our main use case, and can be deployed in DevOps pipelines to validate end to end features
* Performance testing - measuring the responsiveness of a web app accurately and consistently

Selenium provides the **Web Element** class that can be used to facilitate actions in the browser. It works as a default class with some basic functionality supported.

## Setup

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

Next, we will need to include the driver of the browser we want to use if using a version of **Selenium** older than V 4. Selenium uses this executable to interact with the browser instance.

Use one of the links below to download your particular driver, and include it in the `src/main/resources` folder:
* [Chrome](https://chromedriver.chromium.org/downloads)
* [Firefox](https://github.com/mozilla/geckodriver/releases)
* [Edge](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)

Keep in mind that version 4.* of the **Selenium** dependency will work without any extra set up. To create a browser instance and go to google.com we can do the following:
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
driver.quit(); // make sure to always quit the driver when finished
```
**NOTE**: different implementations of the WebDriver (such as ChromeDriver or EdgeDriver) have different Option classes that allow you to configure the settings for the browser that **Selenium** uses for automation. Depending on the browser you are using the flags you will add to the option object will be different
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--incognito");
WebDriver driver = new ChromeDriver(options);
```
Note that if you need to open a browser using a profile (common when testing in enterprise virtual machines) using your browsers option class is how you would activate the profile

## Locator Strategies
Selenium utilizes a class called **By** to determine how to locate elements on a web page. The **By** class has a method associated with each of the following **locator strategies**:
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

## XPath
Not all web pages are designed with Selenium automation in mind: you may be limited in your locator strategy options you can use. No matter the case, one option always available for use is **Xpath**. **Xpath** is a path reference to an element that navigates through the browser DOM much like a file path. Similar to a file path, **absolute Xpath** and **relative Xpath** can be used to reference one or more elements. Consider the following html:
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    <div id="divOne">
        <p>This is paragraph element one text</p>
    </div>
    <div id="divTwo">
        <p>This is paragraph element two text</p>
    </div>
</body>
</html>
```
If you wanted to reference the first paragraph element you could use the following **absolute Xpath**: ```html/body/div[1]/p```. Much like an absolute path for a file on your computer, **absolute Xpath** is a reference to your element that follows the path to it from the start of the html content to its location. Similarly, if you wanted to use **relative Xpath** to access the first paragraph element you would use the following **Xpath**: ```//div[1]/p```. The relative path is able to start at the first div element, which leaves only one possible p element to be returned

**Xpath** supports a host of other features for finding resources, such as text comparison, functions, and more. [This](https://devhints.io/xpath) website is an excellent resource for learning more about the ways you can locate elements using **Xpath**

## Driver Interactions

### Navigation
Driver objects have access to a method called "navigate" that can be used to perform basic navigation actions in the browser. Note the main difference between using the **get** method and **navigate.to** is the former does not save session data (cookies).
```java
driver.navigate().back(); // simulates clicking the back button
driver.navigate().forward(); // simulates clicking the forward button
driver.navigate().refresh(); // simulates clicking the refresh button

driver.navigate().to("url"); // same as driver.get("url"), except it saves session data
```

### Locating Web Elements
The driver uses whatever locator strategy you provide in order to find elements on the web page. You can look for an individual element or all elements that match the chosen locator strategy
```java
driver.findElement(By.id("someId")); // will return the first element found with the given id
driver.findElements(By.class("someClass")); // will return all elements with the given CSS class
```
Selenium will throw a `NoSuchElementException` if no element can be found via "findElement". Also, sometimes an element will become "stale": this means you have a reference to an element that used to be on the web page, but no longer exists (think changing web pages). If you try to use it you get a `StaleElementException` as shown below.

```java
WebElement myElement = driver.findElement(By.id("someId"));
driver.get("http://someothersite.com");
myElement.click(); // StaleElementException thrown here
```

### Interacting With Web Elements
There are some common actions that can be taken on any element returned from the findElement method:
- **clear()**: removes any text content from the input field
- **click()**: this simulates a user clicking on the center of the element
- **getAttribute(String attribute)**: returns the value of the given element attribute
- **getText()**: returns any text content in the element
- **sendKeys(String keys)**: this simulates the user entering text into an input
    - if uploading a file you can use sendKeys to provide the file path of the resource you are uploading
- **submit()**: deprecated, but still supported for compatibility. Used to be the preferred way of submitting web forms

### Waits
There are scenarios when you will need to tell Selenium to "wait" for a condition on the web page to be met: the element could load after a planned delay, latency may fluctuate, etc. Selenium has three different "wait" types to help you prevent Selenium from throwing uncessary exceptions:
- Implicit Waits
- Explicit Waits
- Fluent Waits

#### Implicit Wait
Implicit waits are a global configuration on the `WebDriver` object and apply every time the DOM is queried
```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().wait(Duration.ofSeconds(1)); // this tells the driver to wait up to one second for elements to be found on the page
```

#### Explicit Wait
Explicit waits apply individually and adjust the waiting time explicitly and dynamically at regular intervals. For example, if it usually takes 3 seconds for an element to load, you can use an explicit wait to tell Selenium to pause execution while waiting for that element to load. This allows you to avoid adjusting your implicit wait to accommodate an outlier element that takes a long time to load, but it also allows you to wait for many other situations (alert present/gone, title text, element hidden, etc.) You should always prefer explicit waits to solutions like Thread.sleep(). They are not only more performant but have well documented and defined behavior, and work with a wide variety of conditions.
```java
WebElement invalidElement = driver.findElement(By.id("someId"));
WebElement myElement = new WebDriverWait(driver, Duration.ofSeconds(5))
   .until(ExpectedConditions.elementToBeVisible(By.id("someId")));
myElement.click(); // driver will wait up to five seconds for the element to be visible
```
There are many other "expected conditions" you can use from the `ExpectedConditions` class, which you can find in the API documentation. A few use cases are listed below:
* Waiting for an element to exist, be invisible, be clickable, to contain certain text
* Waiting for the URL or title of the page to match a pattern
* Waiting for a certain number of matched elements to appear
* Combining wait conditions with logical `.and()` and `.or()` methods

#### Fluent Wait
**Fluent waits** take Explicit Waits a couple steps further.
* we still have the ability to set the time we are waiting
* we still have the ability to provide some Expected Condition
* we also have: 
  * the ability to control the frequency at which we are polling the page (checking if the condition has been met)
  * the ability to ignore any exceptions that might be thrown

```java
new FluentWait<WebDriver>(driver)
    .withTimeout(Duration.ofSeconds(10)) // how long in total to wait for the page/DOM to load
    .pollingEvery(Duration.ofSecond(2)) // during those 10 seconds - we are looking at the DOM every 2 seconds
    .ignoring(ElementNotInteractableException.class) // if any exception occurs - we ignore it and keep polling
    .until(ExpectedConditions.visibilityOf(someWebElement)); // specifies what condition to be looking for
```

### Alerts
To manage alerts in the browser you have to tell the driver to "switch" to the alert before interacting with it:
```java
Alert alert = driver.switchTo().alert();
alert.getText(); // returns the text content of the alert
alert.sendKeys(); // sends text to the alert, can be used if the alert accepts input
alert.accept(); // clicks the "ok" button on the alert
alert.dismiss(); // clicks the "cancel" button on the alert
```

### Actions API
Selenium WebDriver makes use of HTTP to interact with the browser: for most interactions this is fine, but sometimes you need a more true-to-the-user way of interacting with the browser (drag and drop, moving a slider via click and drag, drawing in a canvas, etc.). In these scenarios Selenium has the Actions API: using the Actions class you can chain together a collection of commands that give you more fine-tune control over the user mouse, keyboard, wheel, and pen if one is connected. These actions you chain together can then be executed immediately or saved in an Action object for future use

```java
// example taken from lecture demo
            new Actions(driver)
                    // moves to the given position in the browser
                    .moveToLocation(sliderTopLeft.getX(),sliderTopLeft.getY() + sliderWidthAndHeight.getHeight()/2 )
                    // makes the mouse click and hold
                    .clickAndHold()
                    // moves 60 pixels to the right
                    .moveByOffset(60,0)
                    // releases the mouse button
                    .release()
                    // this tells Selenium to build and execute the chain of actions
                    // build() would instead build and return an Action object that could be used later
                    .perform();
```

### Screenshots
Selenium has the ability to take a screenshot of the browser render pane and save the data to a File object in your Java code. This can be particularly useful when using Selenium for testing purposes to have a visual of what the webpage you are interacting with looks like when things go wrong, and is a better alternate than trying to add clunky sleep calls in your test code
```java
// TakesScreenshot is an interface that implements getScreenshotAs, so we cast the WebDriver to it in order to gain access to the method
File fileData = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// remember that you make a Path (singular) object via Paths (plural) get() method
Path screenshotDestination = Paths.get("src/main/resources/filename.jpeg"); // can choose an extension of your choice
// Use the Files (plural) class to copy the file data to your destination
Files.copy(fileData.toPath(), screenshotDestination);
```

### Windows & Tabs
Selenium WebDriver treats windows and tabs the same, and it does not keep track of the active window in your operating system. Because of this, if you ever click a link that opens in a new tab or window you will need to tell the driver to switch to the new view
```java
// example taken from Selenium docs
    //click on link to open a new window
    driver.findElement(By.linkText("Open new window")).click();
    //fetch handles of all windows, there will be two, [0]- default, [1] - new window
    Object[] windowHandles=driver.getWindowHandles().toArray();
    driver.switchTo().window((String) windowHandles[1]);
```
if you want to know what window the driver is currently working with you use the getWindowHandle() method
```java
driver.getWindowHandle();
```

### Upload Files
Selenium is unable to interact with the browser file upload window, but it can provide the path to the file you intend to upload to the input web element. You simply use the "sendKeys()" method and provide the absolute file path. This will provide the necessary information for the browser to upload the file