# HTML

HTML stands for Hypertext Markup Language. It is the standard markup language used to create web pages. HTML defines the structure and layout of a web page using a series of elements, such as headings, paragraphs, images, and links.

HTML is used in conjunction with other languages like JavaScript and CSS to create dynamic and interactive web pages.

A web browser has an interpreter to convert our markup language into pixels to be displayed on the browser. HTML is the markup language that the interpreter understands, and we can write it in an established structure that the browser expects. The language is quite forgiving, in that the browser will attempt to fix any broken HTML in order for it to still be interpretable.

When we are writing HTML, we are defining the structure of the webpage in large blocks called elements that the web page will use and convert into something that can be displayed. An element consists of 3 parts:

1. The opening tag
2. The content
3. The closing tag.

## Tag

A denotation of the start and end of a block of data

Let's use the <p> tag which defines a paragraph. If we want a paragraph to appear on the webpage, we would write in the file

`<p></p>`

This line begins and ends with the same syntax <p>, the difference being the / that is added to the closing tag. The / tells the interpreter that the element is finished, and so any tag that has a / in front is referred to as a closing tag.

## Content

Literal text or other elements contianed between an elements opening and closing tag

`<p>Hello</p>`

No the webpage would render this as a paragraph with text that says "Hello". A paragraph element that has the content "Hello".


## Common Tags

- `<html>`: Defines the entire HTML document
- `<head>`: Defines the head of the document, which contains metadata such as the title of the page
- `<body>`: Defines the body of the document, which contains the content that is displayed in the browser
- `<p>`: Defines a paragraph
- `<h1>`: Defines a level 1 heading, and goes up to 6
- `<img>`: Defines an iamge
- `<a>`: Defines a hyperlink
- `<div>`: Defines a section of the document
- `<span>`: Defines a small section of the document, used to apply styles to specific parts of the text
- `<ul>`: Defines an unordered list

## Semantic Markup

The practice of using tags with special meaning in their specifically designed purpose in order to convey the meaning of the webpage to assitive technology

With CSS, you can format any tag to look like anything you want, even other tags. By using the correct semantic tags, it doesn't affect what is displayed on the screen too much, it simply groups it together in a logical and readable format for the developers and any users that use assitive technologies to interact with a browser.

## HTML DOM

HTML Document Structure where DOM is Document Object Model, refers to the way in which different elements of an HTML document are organized and nested within each other. An HTML document is made up of a series of tags, which define the structure and layout of the page.

The basic structure, requires these three tags:

- `<html>`: The root element of an HTML document and contains all other elements on the page
- `<head>`: The element containing all the metadata about the document, such as title of the page
- `<body>`: The element containing the visible contents of the page

The body can be further divided into sections using tags like:
- `<header>`
- `<nav>`
- `<main>`
- `<article>`
- `<aside>`
- `<footer>`

The three main tags compose the document. The structure should be maintained, and the browser will attempt to do that if it receives broken HTML. This structure can be viewed as a tree that follows a hierarchy of points called nodes, leading up to a single node called the root.

```HTML
<html>
|
|\
| <head>
|       \
|        \
|
<body>
    \
    | \
    |  <nav>
    |       \
    \        <p>
     \
      \<main>
```    

## DOM

Stands for the Document Object Model. A representation of the HTML document in memory. It is generated and can be manipulated by Web API's to change the look of the page as it is being viewed.

When the page gets rendered by the browser, the DOM is used to represent our page behind the secenes gets added to it. Typically we use JavaScript to manipulate the DOM, but we can use any language as any Web API can interact with the DOM.


## Elements and Attributes

We've seen them already in some examples like the image tag.

### Element
An opening tag, a closing tag, and all the content in between them.

### Attribute
A key value pair used to set various properties of a tag. These are always set in the opening tag.

The terms tag and element are often used interchangeably, which is confusing. The functionaltiy and structure is determined by the tag, but the entirety from start to finish is referred to as the element.

Anatomy of a HTML Element

```text
<p class="nice">Hello World</p>

<p> is the opening tag
class="nice" is the attribute and its value
Hello Worl is the enclosed text content
</p> is the closing tag
```

The entire thing is called the element, but the look and feel of the element is set by what tag we use.

## Inline vs Block Elements

We've seen a number of elements already, with each having unique looks and feels. Two elements in this example that we will be studying is `<p>` and `<span>`.

```html
<p>foo</p>
<span>Bar</span>
```

### Result
```
foo

Bar
```

```html
<span>Foo</span><span>Bar</span>
```

### Result

```
FooBar
```

### Inline

An element display style in which the element will stretch to take up only as much space as its content

### Block

An element display style in which the element will stretch to take up the entire width of their container. It will always begin on a new line and it will always be followed by a new line.


### Examples

Block Elements
- `<h1> - <h6>`
- `<p>`
- `<div>`
- `<ol>, <ul>, <li>`
- `<table>`
- `<section>`

Inline Elements
- `<a>`
- `<span>`
- `<input>`
- `<label>`
- `<cite>`


## Global Attributes

Global attributes are those that can be applied to any element on the page, some key ones are:

- class: The class attribute is often used to point to a class name in a stylesheet. It can also be used with JS for manipulating specific class elements
- id: The id attribute gives a unique id to an element. THe value of the id attribute must be unique within the HTML document. 
- hidden: The hidden attribute is a boolean attribute. When present, it specifies that an element is not relevant and the browser should not display it
- style: THe style attribute is used to add styles to an element, like color, font, size, and more

## Input Elements and Input Types

An HTML form collects information from input elements. We will specify an additional attribute named type to indicate which field to display. Various fields can be created such as the text field, checkbox, password field, or radio button.

### Button

A button element is used to represent a button on the screen with no additional functionality

```html
<input type="button" value="this is a button">
```

### Text Field

A text field is a one-line input field that allows the user to input a line of text.

```html
<form>
    <label for="email-input">Email Input</label><br/>
    <input type="text" name="email-input">
</form>
```

### Password Field

```html
<form>
    <label for="user-password">Password</label><br/>
    <input type="password" name="user-password">
</form>
```

### Radio Buttons
Radio buttons are used to let the user select exactly one value from a list of predefined options.

```html
<form>
    SELECT FAVORITE
    <br/>
    <input type="radio" name="favorite-fruit" id="apple">
    <label for="apple">Apple</label><br/>
    <input type="radio" name="favorite-fruit" id="banana">
    <label for="banana">Banana</label><br/>
    <input type="radio" name="favorite-fruit" id="grapes">
    <label for="grapes">Grapes</label><br/>
</form>
```

## Forms

Forms are a way to gather user input in HTML and can be created using the `<form>` tag. This tag is used to define a form and contains form elements such as text fields, check boxes, radio buttons, and submit buttons.

```html
<form id="login-form">
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username">
    <br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password">
    <br>
    <input type="submit" value="Submit">
</form>
```

### Select and Multi Select
The select element is used to create a drop-down list. It is most often used in a from, to collect user input.
The name attribute is needed to reference the form data after the form is submitted. If you omit the name attribute, no data from the drop down list will be submitted.

The id attribute is needed to associate the drop-down list with a label.
The option tags inside the select element defines the available options in the drop-down list.

```html
<form>
    <label for="select">Select Fruit:</label><br>
    <select id="select" name="select">
        <option value="apple">Apple</option>
        <option value="banana">Banana</option>
        <option value="kiwi">Kiwi</option>
    </select>
    <br>
    <input type="submit" value="Submit Button">
</form>
```

If you wanted multiple selection options, there is the `multiple` boolean attribute that allows the user to select more than one option. We can modify the above code to select more than one fruit by adding the multiple attribute to the select tag.

```html
<select id="select" name="select" multiple>
```

The submit button allows the user to send the form data to the web server. You can define a submit button by specifying the type attribute as "submit".

```html
<input type="submit" value="Submit">
```

There is also the reset button, that will reset the form data and will display any default values. You can define a reset button using the type attribute "reset"

```html
<input type="reset" value="Reset">
```

## Attributes used in HTML Forms

- action
    - The action attribute indicates where the form data will be processed. Typically the URL of the server
- target
    - Used to specify whether the submitted results will open the current window, a new tab, or new frame. The default value is "self" which is the same window. For a new window, use "blank"
- name
    - should be provided for each input element. It is not required, but hte value provides a label for the data once the form is submitted. If it is not specified in an input field then the data will not be sent from that field
- method
    - Used to specify the HTTP method used to send data while submitting forms, only two options GET and POST
- value
    - Specifies an initial value for the input field. It also serves as the attribute when providing a button a label
- placeholder
    - Used to give a hint to describe the expected data in the form.
- required
    - Required attribute indicates that an input field must be filled out before submitting the form. Most modern browsers prevent form submission until these fields are filled out
- min and max
    - Used to specify the range of values allowed in an input field. This only works with these input types: number, range, date, datetime-local, month, time, and week.

```html
<form action="http://localhost:3000/login", target="_blank" method="GET">
    <label for="name">Name:</label><br>
    <input type="text" required placeholder="Mark">
    <br>
    <input type="reset" value="Reset">
    <input type="submit" value="Submit">
</form>
```

# CSS

CSS stands for Cascading Style Sheets. It is a language for styling HTML documents by specifying certain rules for the layout and display of elements with key value pairs. 

A CSS consists of a set of rules that defines the web page. This style sheet contains selectors and declarations. The selector is an HTML element, and the declaration is comprised of a property and a value surrounded by curly braces.

```css

h1 {
    color: red;
    font-family: Arial;
    font-style: italic
}
```

## Inline, Internal, and External Style Sheets

There are three types of CSS:
- Inline
- Internal or Embedded
- External

### Inline CSS

Inline CSS contains the CSS property in the body section attached with an element. This kind of style is specified when using the style attribute in a HTML tag.

```html
<p style="color: crimson; font-size: 50px; text-align: center">
    Lorem ipsum dolor sit.
</p>
```

### Internal or Embedded CSS

This can be used when a single HTML document must be styled uniquely. The CSS rule set must be placed in the head section.

```html
<head>
<title>CSS Examples</title>
<style>
    h1 {
    color: red;
    font-family: Arial;
    font-style: italic;
    }

    h2 {
    color:blue;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow';
    }
</style>
</head>
```

### External CSS

External CSS contains separate CSS files which contains only style property with the help of tag attributes (class, id, heading, etc). CSS in a separate file, must have the .css extension and should be linked to the HTML document using the `<link>` tag.

```html
<head>
    <link rel="stylesheet" href="./css_example.css"/>
</head>
```

Linked CSS File
```css
body {
    background-color: darkcyan;
}
```

The order in which styles are applied are like so: External, Internal, then Inline. This means that any style applied as Inline CSS will always override external and internal CSS even with clashing properties that are being applied styles.

## CSS Box Model

The CSS Box Model is used to determine how a web page is rendered by a browser. It considers each element on the page as a box, and with CSS it allows you to apply different properties that define where and how that element appears.

```
|Margin|Border|Padding|Content|Padding|Border|Margin|
```

Every box has 4 parts - margin, border, padding, and content. The margin is the outermost box, then the border, then padding, then finally content being the innermost.

- Margin:
    - The outermost. Useful for separating elements from its neighbor. The dimensions are given by the margin-box width and the margin-box height
- Border:
    - The area between the box's padding and margin. The dimensions are given by the width and height of the border
- Padding:
    - The space around the content area and within the border box. It's dimensions are given by the width and height of the padding-box
- Content:
    - It consists of content like text, image, or other media.

```css
#box_example{
    width: 300px;
    height: 300px;
    padding: 10px 30px 10px 10px;
    border: 2px solid blue;
    margin: 20px;
}
```

## CSS Properties

There are a number of CSS properties that we can use to style our page.

- Border
    - `border-width: medium 10px thick 15px;`
    - `border-style: dotted;`

- Padding
    - `padding: 70px;` Sets the padding to 70 pixels for four sides
    - `padding: 35px 45px 30px 10px;` Sets the padding from top clockwise in the order it was written

- Color
    - The color property is used to specify the foreground color of text
    - There are 5 different color notations
    - ```css
        a {color: red;}
        div {color: #3c5;}
        h1 {color: #ffa500};
        div {color: rgb(100, 20, 255);}
        div {color: rgb(30%, 50%, 80%);}
        div{color:rgba(132, 104, 187, 0)}

- Text-align
    - ```css
        div{text-align:left;}
        h1{text-align:right;}
        div{text-align:justify;}
        div{text-align:center;}


## Element Selectors

The element selector selects HTML elements by their name / tag name like `h1` or `a`.
The element selector is a way to select all the elements with a given tag name in a document, and apply the same styles to each element with the tag name. You should not write the angle brackets around the element with CSS.

```css
p {
    text-align: center;
}
```

### Class and ID Selectors

The class selector is a name preceded by a period `.`. It uses the class attribute of an HTML element to match the specific HTML element. We can have a class selector specific to an HTML element like `p.class` which will select an element of type paragraph that has the class property name "class".

### Class Selector
```css
p.paragraph_class{
    color: rgb(108, 9, 67)
}
```
The above example will only apply the style to paragraph elements that have the class attribute "paragraph_class".

### ID Selector
The ID selector name should be preceded by a `#`. It uses the ID attribute of the HTML element to match the specific HTML element.

```css
#specific_paragraph{
    color: #22e23c
}
```
ID selector is the most specific selector, and so will override any styles except another id selector. In that case, it is based on which one is applied last (styling is applied top to bottom).

## Sibling Selectors

### Adjacent Sibling Combinator Selector
An adjacent sibling combinator selector allows you to select an element that is directly after another element

```css
p + p { font-size: smaller; } /* Selects all paragraphs that follow another paragraph */
```

### General Sibling Selector

Very similar to the adjacent sibling combinator selector but the element being selected doesn't need to immediately succeed the first element, but can appear anywhere after it.

```css
p ~ p { font-size:smaller;}
```

### Universal Selector

The universal selector denoted by an asterisk `*`, matches all the elements on the page. If any other specific selector exists on teh element, then the universal selector will be omitted.

```css
* { background-color: red;}
```

### Attribute Selector

The attribute selector is used to specify an element that contains a specific attribute or an attribute with a specific value. This is done using the name of the attribute inside a square bracket `[]`.

- `[attribute]` Selector
    - Used to apply the style rule for all the elements which has a specified attribute
- `[attribute="value"]` Selector
    - Uses the `=` operator to select elements whose attribute match the value exactly
- `[attribute^="value"]` Selector
    - using the `^=` operator to select elements that have the specified attribute and with a value beginning exactly with a given string


### Grouping Selector
The CSS grouping selector is used to apply a common style for the page. You can group the selectors using a comma separated list. This applies the same properties and rules for more than one element at a time.

```css
h1, h2, p {
    font-family: Arial;
    color: blue;
}
```

### Child Selector

These will select the children of a specified element. The syntax uses a `>` to indicate which element is the parent and which is the child.

```css
div > p {
    background-color: red;
}
```

### Descendant Selector

The descendant selector selects all the elements which are a child of the element. It allows you to limit the targeted elements to the ones who are descendants of another element.

```css
div p {
    background-color: red;
}
```

## Responsive Web Design

This is the approach that allows websites and pages to render on all devices and screen sizes by automatically adapting to the screen that it is being displayed on. This works using CSS by having different settings to serve different style properties depending ont he screen size, orientation, resolution, color capability, and other characteristics of the user's device. It combines flexible grids, flex boxes, flexible images, and media queries.

### CSS3 Media Queries

CSS3 supports responsive web design, all kinds of transitions, transformations, and animations and provides box-sizing tools that enable the user to adjust the size of any element without changing the dimensions or padding of the element.

```css
#media not|only mediatype and (mediafeature and|or|not mediafeature){
    css code
}
```

Media Types:
- all : used for all media type devices
- print : used for printers
- screen : used for screens like computers, tablets, smart phones, etc
- speech : used for screen readers that reads the page aloud

Media Features:
This describes the specific characteristics of the user agent, output device, or environment.
- grid
- height
- width
- hover
- max-aspect-ratio
- max-color
- max-height

Logical Operators:
Used to compose a media query

```css
@media only screen and (max-width: 600px){
    body{
        background-color: red;
        font-family: Arial;
    }
}
```


## Flexbox
This is a one-dimensional layout method for arranging elements in rows or columns. 
In any Flexbox layout, the first step is to create a flex container. THe flex container is an area of document laid out using Flexbox. We can define it like so

```css
.flex-container{
    display: flex;
}
```

The items being represented as flexible boxes inside the flex container are called flex items. The direct children of the flex container are called flex items.

Properties of Flex Container:
- `flex-direction` : used to change the direction of the flex items display.
- `flex-wrap`: used to define the flex items that should wrap or not
- `justify-content`: used to align the flex items within the container

Properties of Flex Items:
- `align-items`: used to align the flex items vertically
- `order`: used to define the order of the flex items
- `align-self`: used to define the alignment for a specific flex item which can override the default alignment

## CSS Grid

The CSS grid layout excels at diving a page into major regions or defining the relationship in terms of size, position, and layer, between parts of a control built from HTML primitives.

Like tables, grid layout enables you to align elements into columns and rows. However, CSS grid is far more flexible than using tables. A grid container's child elements could position themselves so they actually overlap and layer, like CSS positioned elements.

```css
.wrapper{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 10px;
    grid-auto-rows: minmax(100px, auto);
}
.one {
    grid-column: 1 / 3;
    grid-row: 1
}
.two {
    grid-column: 2/4;
    grid-row: 1/3;
}
```

## Bootstrap
Bootstrap is an open-source framework and mobile-first approach to developing responsive websites. It is a front-end framework programmed to support both HTML5 and CSS3.

### Bootstrap Grid System
The bootstrap grid system consists of series of containers, rows, and columns to layout and align content. It creates a responsive layout and is built using grids and Flexboxes.

Containers:
To specify a container, there are two container classes that we can use
- `.container`: used to provide a fixed width container
- `.container-fluid`: used to provide a full-width container that spans the entire width of the viewport

```html
<div class="container">
    This is a fixed container
</div>
<div class="container-fluid">
    This is a fluid container
</div>
```

Rows:
Bootstrap rows are horizontal slices of the screen. THey are only used for containing columns or a wrapper for columns. They have to be placed in containers to avoid the horizontal scroll on the page. 

```html
<div class="row">
...
</div>
```

Columns:
`.col` class is used to set the width for the column dynamically. Grid system supports a maximum of 12 columns in a row and anything after that will be shifted to the next row.
You can set the size for the column (ranging from 1 to 12).
```html
<div class="row">
    <div class="col-3">
        this is col-3
    </div>
    <div class="col-5">
        this is col-5
    </div>
    <div class="col-7">
        this is col-7
    </div>
</div>
```

Also, we can set breakpoints for columns and this is used to specify the screen resolution.

- `.col-sm`: used for small devices with a width of equal or greater than 576px
- `.col-md`
- `.col-lg`
- `.col-xl`

### Bootstrap Tables
This is used to style HTML tables and to change the default styles for them. To add bootstrap to a table, add the class `table` to it.

```html
<div class="container">
    <table class="table">
        <tr>
            <th>Header</th>
        </tr>
        <tr>
            <td>Item 1</td>
        </tr>
        <tr>
            <td>Item 2</td>
        </tr>
    </table>
</div>
```