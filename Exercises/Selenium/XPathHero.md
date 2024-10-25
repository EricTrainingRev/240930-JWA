# XPath Hero

## Objective
Practice extracting information from HTML documents using XPath. The goal is to become proficient in writing XPath queries to locate specific elements within a webpage.

## Description
XPath Hero is an activity designed to enhance your skills in using XPath to navigate and extract data from HTML documents. Using the provided resources, you will write XPath queries to locate elements as specified in the `questions.md` file. This activity will help you become more comfortable with XPath syntax and its practical applications.

## Main Goals
- Practice writing XPath queries to locate elements within web pages.
- Understand the difference between absolute and relative XPath expressions.
- Gain proficiency in using browser DevTools to test XPath queries.

## Requirements
- **Write XPath Queries**: For each question in the `questions.md` file, write an XPath query to locate the specified element(s).
- **Test XPath Queries**: Use the browser DevTools to test your XPath queries and ensure they correctly locate the elements.

## Instructions

### Setup
1. Download the files in the XpathHero directory.
2. Open the HTML files in Google Chrome or your preferred browser.

### Write XPath Queries
1. **Open DevTools Console**: In Chrome, open the DevTools Console by pressing `Ctrl+Shift+I` (Windows/Linux) or `Cmd+Option+I` (Mac).
2. **Select Elements Using XPath**: For each bullet point in the `questions.md` file, write an XPath query to locate the specified element(s). Test your queries by typing `$x("xpath string")` into the DevTools Console.

### Example
```html
<!DOCTYPE html>
<html>
    <head>
        <title>Example</title>
    </head>
    <body>
        <div class="inputs">
            <input id="exInput" class="demo" type="text">
            <input id="ex2Input" class="demo" type="password">
        </div>
    </body>
</html>
```
to select the password input:
- Absolute path
    - ```/html/body/div/input[2]```
- Relative path (non-exhaustive list)
    - ```//input[@type='password']```
    - ```//div/input[2]```
    - ```//div/input[@type='password']```