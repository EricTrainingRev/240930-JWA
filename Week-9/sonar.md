## Sonar
- Family of software used for detecting code defects, code smells
- Code Smells
  - Vulnerabilities
    - Security
      - passwords that aren't hashed/protected
      - exposed credentials
    - Maintainability
      - Confusing Code
      - Repeated Code
      - Unused Imports
      - Empty Code Blocks
      - Unaddressed Comments
      - Design Patterns being violated/misused
      - SOFA/SOLID Acronyms
    - Bugs
      - Functionality of the Code

### Sonar Cloud
- Upload code or connect Github account and link up your repository at which point the code will be analyzed for code smells
#### Demo
- Navigate to [Sonar Cloud](https://sonarcloud.io/login)
  - Optionally, log in with Github
  - Fill out username/password if prompted
- On the top right, click "+", "Analyze New Project"
  - Select our project
  - Select organization, project itself, click "Setup" on the right
  - On the next screen, can select "Previous Version"
- After the project is done being analyzed, we can view the smells by category (maintainability, security, reliablity)
  - After hovering over a particular issue, can click "More Details" to see the exact issue

#### Optional Activity for Project
- Make a SonarCloud account (most likely connecting Github)
- Upload project code and run an analysis

### Sonar Lint
- Extension on VSCode or plug-in for IntelliJ
- Analyzes your code in real-time as you write it, pops up with suggestions like a typical text editor

#### Demo
##### VSCode
- Go to Extensions tab on the left side-bar
- "Search Extensions in Markeplace", SonarLint
- Click on the extension and then "SonarLint"
- Open up a project and view the Intellisense

##### IntelliJ
- File -> Settings -> Plugins
- Search for SonarLint on the IntelliJ plugin marketplace
- Click the "Install" button

#### Optional Activity
- Install SonarLint on your IDE and pay attention to the feedback while you write code for your project

