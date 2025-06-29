Trendyol Automation Project
This project is developed to perform automation tests on the Trendyol website using Selenium and Cucumber.

Technologies
Java 11
The primary programming language used.

Selenium WebDriver
For web browser automation.

Cucumber BDD Framework
For Behavior-Driven Development (BDD) and writing human-readable test scenarios.

Maven
For project and dependency management.

Apache POI
(Optional) For reading/writing data from Excel files, if applicable.

maven-cucumber-reporting
For generating comprehensive HTML reports from Cucumber test results.

Getting Started
Follow these steps to set up and run the project locally.

Prerequisites
Java Development Kit (JDK) 11 or higher:

Ensure JDK 11 or a newer version is installed on your system.

Verify that the JAVA_HOME environment variable is set correctly.

Maven:

Ensure Maven is installed and configured in your system's PATH.

Web Browser and Drivers:

Install the web browser(s) you intend to use for testing (e.g., Chrome, Firefox).

Download the corresponding browser driver (e.g., chromedriver for Chrome) and either add it to your system's PATH or specify its location in your WebDriver initialization code.

Installation
Clone the Repository:

git clone https://github.com/QArtistt/TrendyolSeleniumAutomation.git

Navigate to Project Directory:

cd TrendyolSeleniumAutomation

Install Dependencies:

mvn clean install

Running Tests
To execute the automation tests, use the Maven verify phase. This will run the configured test runners (e.g., CooksRunner.java) via maven-surefire-plugin.

mvn clean verify

Test Reports
Upon completion of the tests, detailed HTML reports will be generated at:

target/cucumber-html-reports/index.html

Open this file in any web browser to view the test results and execution details.
