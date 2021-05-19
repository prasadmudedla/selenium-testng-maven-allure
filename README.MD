# Assignment

This project has test to verify, Automation Practice website functionality. It is using Page Object Pattern and  written in Java using selenium.

## Getting Started

To get started install the required software and run the test to verify.

### Prerequisites

Install the below prerequisites
- Java v1.8
- Maven
- Any IDE(Preferably IntelliJ)
- Allure(should be 2.10.0) : Download from [here](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.10.0/allure-commandline-2.10.0.zip) and set [allure bin in the path](https://docs.qameta.io/allure/#_manual_installation)

## Running the tests

To run the tests use any of the two ways mentioned below.
```Add USERNAME and PASSWORD in src/main/resources/config.properties```
- Running using maven
    - Open the project in terminal and run below command
      ```$ mvn clean test```
- Running testng.xml through IDE
    - Import the project to IntelliJIdea/any IDE, Build the project. Right click on testng.xml and select run.

## Project Folder Structure
### src
- src is the root folder which consists of Main folder and test folder
  #### main
    - Main has Java which consists of the java related files supporting the frame Work. It has Pages and utils folders.
      ##### Pages
        - Pages consists of the pages to support the framework. Pages contain objects and methods for a particular page.
      ##### Utils
        - This folder consists all the utilities required for the framework.
      ###### Fetching configuration from config properties file and creating constant variables.
        - config.properties file in resources consists of configuration properties and test data for project.
        - Configutil class will fetch the properties file.
        - Config class will convert all the properties in config to static final variables
      ###### Driver Factory
        - The Driver factory class will create a driver required for the test`
      ###### WebElementUtils
        - This class consists of the utilities used by webdriver extracted.
  #### test
    - This folder consists of tests inside 'java->tests'

  #### resources
    - config.properties
        - This file consists of properties and test data.
        - Please add user name and password.

## Run the Tests
- setUp Method
    - This method will open twitter and logs in user.
- Test
    - This will verify all the flows for the Already Registered Section
- tearDown
    - This method will again unfollow user to make sure test runs fine when ran second time.

## Generate the Reports
Run the below commands to see the report.
```
allure generate target\allure-results --clean -o allure-report
allure open
```
    
