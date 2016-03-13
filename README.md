# Technical Exercises #

The design approach to this Technical Exercise is a Hybrid Framework that consists of Page Object Pattern with Test Data Driven Method.

### Pre-requisites ###

* Maven 4.0.0
* Selenium WebDriver 2.52.0
* TestNG 6.9.10
* JExcelApi 2.6.12

### Test Cases ###
The project contains two Tests that are located in src/test/java/com/confluence/test.

* Create New Blank Page – This will test that the user is able to successfully create a new blank page. The script will validate the Browser title, page title, page body, and the page title in the page tree of the side bar. It will delete it afterwards for script re-usability. The values in TestData.xls(located in the same path) will pass the url, username, password, page title and page body.

* Edit Restrictions – This script will test if a user can edit the restrictions of an existing page. The validations are verifying the objects in the edit restrictions dialog window (e.g. the contents of the dropdown, search box, etc.) and applying the different types of restrictions and verifying if they applied. There was no actual adding of groups or people to edit restrictions due to that nothing was searchable. See issues below.


### TestData.xls ###

* Each test case has its own worksheet. The sheet will contain a table to a scenario that the script will call through TestNG.
* The table will contain the test data used to feed parameters in its appropriate script.
* Each row is a group of test data that will be fed by testNG per execution run.
* If a row is marked "No" in the Execute Column, the script will skip over it.
![Screen Shot 2016-03-13 at 7.58.34 PM.png](https://bitbucket.org/repo/q8gEBn/images/2926596532-Screen%20Shot%202016-03-13%20at%207.58.34%20PM.png)

### Issues ###
  - On the edit restriction dialog window, there is no group or people to add to test this particular part of the feature. This might be due to restrictions on trial account user but what you cannot test can be an issue.