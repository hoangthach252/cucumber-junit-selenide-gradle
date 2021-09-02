# Automation Framework using Cucumber JVM6 + JUnit5 + Selenide + Gradle + Allure + logback

A sample BDD Automation framework using Cucumber6, JUnit 5, Selenide, Gradle, Allure, logback.
Support running tests in parallel and sharing data among test steps.
Sample tests against Unsplash web app. 

## Libraries Used

* [Junit](https://junit.org/junit5/docs/current/user-guide/) - 5.7.2
* [Gradle](https://gradle.org/guides) - 7.1.1
* [Cucumber](https://cucumber.io/docs/cucumber/) - 6.11.0
* [Selenide](https://rselenide.org/documentation.html) - 5.24.0
* [Selenide wiki](https://github.com/selenide/selenide/wiki)
* [PicoContainer](https://github.com/cucumber/cucumber-jvm/tree/main/picocontainer) - 6.11.0
* [Allure](https://docs.qameta.io/allure/) - 2.14.0
* [Allure-Selenide](https://selenide.org/documentation/reports.html) - 2.14.0
* [Allure-Cucumber](https://docs.qameta.io/allure/#_cucumber_jvm) - 2.14.0
* [Logback](http://logback.qos.ch/manual/index.html) - 1.2.5
* [AssertJ](https://assertj.github.io/doc/) - 3.20.2

## Run/Debug tests

* run all tests in parallel, number of threads can be specified.

  ```shell
  $ gradle.bat -Dthreads=3 clean cucumber
  ```

* run all tests with specific tag.

  ```shell
  $ gradle.bat -DcucumberTags=@id-002 clean cucumber
  ```

* run all tests in `firefox` browser. (default threads=1)
  ```shell
  $ gradle.bat -Dselenide.browser=firefox clean cucumber 
  ```

* Debug test on IntelliJ IDE.
Trigger Debug using CukesTestRunner.java. (cannot debug using task `cucumber`)


After the tests are ran, you can see:
* logs from file appender under `build/logs/log.log`
* Allure results `build/allure-results`

## ScenarioContext

Represents test context to save/get test data and share it among test steps in one Cucumber scenario.  

Example:  
<code>
scenarioContext.setContext(Context.COLLECTION_NAME, collectionName);
</code>

<code>
String collectionName = (String) scenarioContext.getContext(Context.COLLECTION_NAME);
</code>

## DataStorage
Represents a storage to store test data and handle clean up after each Cucumber scenario.  

Example:  
<code>
dataStorage.setCollectionNames(collectionName);
</code>


## Allure reports
Allure report will contain framework logs, Selenide browser interaction logs, screenshots and page sources for 
failing test cases

* [Allure CLI](https://docs.qameta.io/allure/#_commandline) should be installed
* Allure results stored in `build/allure-results`
* To generate allure report
  ```shell
  $ gradle.bat allureServe
  ```
* Cannot run allureReport gradle task due to this [bug](https://github.com/allure-framework/allure-gradle/issues/60)


## Cucumber configuration

* Glue or steps classes `src/test/steps`
* Feature files `src/resources/features`
* Cucumber property file `src/resources/cucumber.properties`
* Example of test runner `src/test/tests/testrunner/CukesTestRunner.java` for debugging or running in sequential
* Test runner to run cucumber tests in parallel: gradle task `cucumber`


## Logback configuration

You can find logback configuration here `src/test/resources/logback.xml`

Current configuration contains two appenders:

* ConsoleAppender will output logs to system out stream
* FileAppender will output logs to `build/logs/log.log` 