# UI Automation task for XM.com

## Tools and Technologies used

- **Java**: Programming language used for writing test scripts.
- **Selenium**: WebDriver for automating browser interactions.
- **Cucumber**: BDD tool for defining test cases in Gherkin syntax.
- **Maven**: Build automation and dependency management tool.

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
