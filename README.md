# ta_training-java

## Framework -Task 1

_Condition:_
_Use your completed Task 3 from the WebDriver module as a precondition for the current task, in which you need to develop a framework based on it, which will include the following features:_

1. _A WebDriver manager for managing browser connectors_
2. _Page Object/Page Factory for _page_ abstractions_
3. _Models for business objects of the required elements_
4. _Property files with test data for at least two different environments_
5. _XML suites for smoke tests and other tests_
6. _If the test fails, a screenshot with the date and time is taken._


Java WebDriver test automation project for Google Cloud Pricing Calculator

Run from command line: mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=qa clean test
* browser in(chrome, firefox)
* surefire.suiteXmlFiles in (testng-all, testng-smoke)
* environment in (dev, qa)

