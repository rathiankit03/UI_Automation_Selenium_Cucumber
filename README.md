# UI Automation task for XM.com

## Tools and Technologies used

- **Java**: Programming language used for writing test scripts.
- **Selenium**: WebDriver for automating browser interactions.
- **Cucumber**: BDD tool for defining test cases in Gherkin syntax.
- **Maven**: Build automation and dependency management tool.

## Key Directories and Files

- **`pages/`**: Contains classes with web element locators and methods related to page interactions.
- **`runner/`**: Holds the test runner files responsible for triggering test execution.
- **`step definitions/`**: Includes the step definition files that map Gherkin steps to Java methods.
- **`utils/`**: Contains utility classes like ScenarioContext, helper methods, and hooks for test setup and teardown.
- **`driver/`**: Stores the WebDriver executable (e.g., ChromeDriver).
- **`feature/`**: Contains the feature files where test cases are written using Gherkin syntax.
- **`pom.xml`**: Maven configuration file that manages project dependencies.

## Setup Instructions

### Prerequisites

Ensure you have the following installed on your system:

- Java
- Maven
- Chrome browser should be up to date to version 129

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/rathiankit03/XM_UI_Automation.git
   cd XM_UI_Automation
   ```

2. ** Install project dependencies and build the project: **

    ```bash
    mvn clean install
    ```
3. ** Run Test **

    ```bash
    mvn test -Dcucumber.options="--tags @regression"
    ```    
