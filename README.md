# Amazon Web App Automation Framework

A professional-grade BDD automation framework for testing Amazon's e-commerce platform. Built with **Java**, **Selenium**, **Cucumber**, and **TestNG**.

## 🚀 Key Features
- **Hybrid Framework**: Combines BDD (Cucumber) with Page Object Model (POM) for maximum readability and maintainability.
- **Parallel Execution**: Thread-safe driver management using `ThreadLocal` allows running scenarios in parallel without session conflict.
- **CI/CD Integrated**: GitHub Actions workflow configured for automated testing on every push/PR.
- **Dockerized Execution**: CI runs tests in a containerized Selenium Grid environment.
- **Smart Bot Detection**: Automated handling of Amazon's bot detection pages (CAPTCHA/Continue Shopping) to ensure test stability.
- **Robust Error Handling**: Graceful skipping of out-of-stock items and resilient locators.

## 🛠 Tech Stack
- **Language**: Java 17
- **Web Driver**: Selenium WebDriver 4
- **BDD**: Cucumber 7
- **Runner**: TestNG
- **Build Tool**: Maven
- **CI/CD**: GitHub Actions

## 📋 Prerequisites
- Java JDK 17+
- Maven 3.8+
- Google Chrome

## 🏃♂️ How to Run

### Run all tests
```bash
mvn test
```

### Run specific tags
```bash
mvn test -Dcucumber.filter.tags="@Search"
```

### Run in Headless Mode (CI style)
```bash
mvn test -DHeadless=true
```

## 📊 Reporting
The framework generates detailed HTML reports after execution:
- Path: `target/Amazon-reports/SparkReport/Spark.html`
- Includes screenshots for every step and failure.

## 🏗 Architecture
- **DriverFactory**: Singleton pattern with `ThreadLocal` for safe parallelization.
- **Page Objects**: Separated locators and web elements.
- **Actions**: Encapsulated business logic and interactions.
- **Steps**: Cucumber glue code connecting Feature files to Actions.
