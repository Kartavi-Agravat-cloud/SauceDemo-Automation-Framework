# SauceDemo Automation Framework

A Selenium + Java test automation framework for [SauceDemo](https://www.saucedemo.com/), 
built with an eye toward realistic e-commerce QA workflows.

## Tech Stack
- Java, Selenium WebDriver, TestNG
- Cucumber (BDD)
- Page Object Model (POM)
- Apache POI (Excel data-driven testing)
- Extent Reports (HTML test reporting)
- Maven
- Jenkins CI/CD

## Features
- Data-driven login tests via Excel (`LoginData.xlsx`)
- BDD scenarios via Cucumber (`login.feature`)
- Cross-browser execution (Chrome, Firefox)
- Parallel execution via ThreadLocal WebDriver management
- Screenshot capture on failure
- Extent HTML reports with embedded screenshots

## Running the tests
mvn clean test

## CI/CD
Integrated with Jenkins for automated build and test execution.