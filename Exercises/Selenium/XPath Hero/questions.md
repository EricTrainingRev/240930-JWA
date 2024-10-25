# Xpath
Selecting Web Elements from the DOM is an essential skill for automating web pages. There are a lot of ways to do Xpath and there is no always best solution. Try to answer the following questions by using Xpath. In chrome console, you can do $x("some xpath")to select these elements. This cheatsheet is also very helpful https://devhints.io/xpath . $x returns an array of elements. Save all your Xpath queries in text file. You should try to do it individually but seek hints from others if you get stuck. Compare queries with your teammates as there are many ways to write these.


## Employee Overview
- Select all tds that have money sign in them
  - hint Use contains()
- Get the first tr in the tbody
  - hint Use position
- Get the last tr in the tbody
  - hint use last()
- Get All tds where the id is between 200 and 300
  - hint use logical operators and [@id]

## Hi Score
- Get the li that conatins TIM's Dig Dug score
  - hint use 'and'
- Get the list items that belong to YVN or GAR
- Get the total amount of li in the document
  - hint use count

## Sales Report
- Select only the second table
- Select all trs where the attribute data-leader="Margaret"
- Select all the tds containing the sales where Westview Middle was the troop
  - hint use parent
- Select the last tr of Thin Mints in the first half
