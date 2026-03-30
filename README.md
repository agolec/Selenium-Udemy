# 1) Selenium Automation Framework

A scalable Selenium automation framework built with Java and TestNG, implementing the Page Object Model (POM) and a Driver Factory pattern to support cross-browser testing and maintainable test design.

## 2) 🚀 Start Here

For evaluation, begin in the `alg/framework/` package.

Key entry points:

* `base/BaseTest.java` – Handles test setup and teardown
* `driver/DriverManagerFactory.java` – Initializes WebDriver instances using an enum-based factory pattern
* `config/ConfigReader.java` – Loads external configuration values

The `org/example/` package contains exploratory and practice implementations and is not representative of the final framework design.

## 3) Tech Stack

* Java - Scripting language
* Selenium WebDriver - Framework under study
* TestNG - Utilized for control flow and test organization for buildup, execution, and teardown of driver instances over the lifetime of a test execution.
* Maven - Dependency Manager

## 4) Framework Architecture

Inside `alg/framework`, the code is structured with a clear separation of concerns:

* Driver Layer - Manages browser initialization using a factory pattern and enums.
* Base Layer - Centralizes test lifecycle management (setup and teardown)
* Page Layer - Implements Page Object Model (POM) for UI Interactions
* Test Layer - Contains test cases and assertions
* Config Layer - Externalizes configuration using properties files
* Utils Layer - Provides re-usable helper methods (waits, element handling, etc)

## 5) Execution Flow

  1. Configuration values are read from config.properties
  2. The selected browser is mapped to a DriverType enum
  3. DriverManagerFactory instantiates the appropriate WebDriver
  4. BaseTest Initializes and manages the driver lifecycle
  5. Tests interact with the application through Page Object classes

## 5) Project Structure

src/main/java/
├── alg/framework/   # Core automation framework
└── alg/learning/    # Exercises, experiments, and exploratory implementations

## 6) How to Run

1. Clone the repository
2. Install dependencies:
   mvn clean install
3. Execute tests:
   mvn test

## 7) Configuration

Browser selection is controlled via `config.properties`:

e.g:
browser=CHROME

The value CHROME is mapped to a `DriverType` enum, ensuring type safety and preventing invalid configurations.

## 8) Features

* Cross-browser support via Driver Factory pattern
* Enum-based driver selection (type-safe configuration)
* Page Object Model (POM) implementation
* Externalized configuration
* Modular and scalable project structure

* ## Learning & Iteration

The `alg/learning/` package contains exploratory implementations and exercises used to validate concepts before integrating them into the framework.

Key patterns and components in the `framework` package were refined from these experiments into a more maintainable and scalable design.

