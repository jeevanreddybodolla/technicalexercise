# Technical Exercises #

The design approach to this Technical Exercise is a Hybrid Framework that consists of Page Object Pattern with Test Data Driven Method.

### Pre-requisites ###

* Maven 4.0.0
* Selenium WebDriver 2.52.0
* TestNG 6.9.10
* JExcelApi 2.6.12

### Test Cases ###
The project contains two Tests that are located in src/test/java/com/confluence/test.

- Create New Blank Page – This will test that the user is able to successfully create a new blank page. The script will validate the Browser title, page title, page body, and the page title in the page tree of the side bar. It will delete it afterwards for script re-usability. The values in TestData.xls(located in the same path) will pass the url, username, password, page title and page body.

- Edit Restrictions – This script will test if a user can edit the restrictions of an existing page. The validations it will make are validating the objects in the edit restrictions dialog window (e.g. the contents of the dropdown, search box, etc.). It will also apply the different restriction options and validate .


### TestData.xls ###

* Each test case has its own worksheet. The sheet will contain a table to a scenario that the script will call through TestNG.
* The table will contain the test data used to feed parameters in its appropriate script.
* Each row is 1 group of test data that will consist of 1 scenario.
  

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact