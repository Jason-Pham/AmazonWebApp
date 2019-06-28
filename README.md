# Amazon web app testing
This is a framework to test Amazon AU web app page. It can help manual tester or anyone who need regression test for basic work flow of this e-commerce service.

## Usage
### There are 2 ways to run this test
1. Run with Maven:
user just need to type ```mvn test``` and the test runner with start its job.

2. Run the test runner itself:
The runners is in this folder:

  > \src\test\java\_runners

Currently there is just one basic test runner, the test cover will be increase by time.

### Some notes for this framework
1. This framework required Java 8+ and Chrome to run. It can work on Mac, Windows, Linux as long as it has Java and Chrome browser
2. There is no web driver attached, the framework will pickup the best Chromedriver version for your Chrome.

## Report
1. The framework will create the report base on the cucumber features that were run, the steps is automatically generated based on  cucumber scenarios
2. Each steps of report would have one or more images attached to it
3. When a test is failed, report will show the error message

## Release Notes
### Release version v1.0
The basic user flow from home page, search page, deal page, product page and cart page is implement in this release.
Framework now have the core pages, features and report for each release.
The Amazon AU website has many user flows and sometimes there are some changes in the DOM. We would try to cover as much changes as we can forseen but gliches could happen.

## What's next
1. Implement the Firefox browser option.
2. Implement the way to dynamic tagging for scenarios, user can run any tags at any time.
3. Implement the parrallel test to decrease testing time as scenario number would be growing.
4. Implement console logs for more inside debug.

## Demo
https://drive.google.com/file/d/1knmOK-KmqwUiSfGNcikHlGc0rzUQt_2J/view?usp=sharing
