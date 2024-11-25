## Jenkins
- Definition - self-contained automation server
  - Automate the building, testing, delivery of software
- Pipelines/Jobs - a repeatable set of steps that automate a task
  - We can set up a pipeline for a project
  - The pipeline would be split up into multiple stages
  - Jobs can be triggered manually, externally, or by another job
- Jobs have health which are indications of how they are "doing"
  - Sunny - more than 80% of tests are passing
  - Partially Sunny - 61% - 80%
  - Cloud - 41% - 60%
  - Raining - 21% - 40%
  - Stormy - < 21%>
- Builds have colors associated with them:
  - blue - success
  - yellow - unstable
  - red - failure
  - grey - no builds just yet

## Demo
- We will utilize Docker and Docker Compose to install Jenkins
- Of course, we don't **need** Docker to run Jenkins but it makes the process much easier and more streamlined
- Of course, Docker isn't just used for Jenkins, it can be used to set up whatever environment we configure for the image

### Docker
- Containers - used to run programs
  - For example, if we have a Java project that runs some back-end code for a web-app
    - We want a new teammate, Ned, to be able to see the code and run the code for themselves
    - If Ned has Docker installed, he can just run a Java container (which would contain all of the dependencies needed to run a Java project, JDK)
    - Using Docker, Ned would be able to run Java app without installing Java on his local machine
- Images - 
  - Static representation of the environment/dependencies that we need
  - ex: we could have an image for JDK, Node application, Jenkins, Splunk
- Containers
  - Running instance of the image
  - We wouldn't be able to use the program in question without the container (can't do much with just the container)

### Docker Install
- [Windows](https://docs.docker.com/desktop/setup/install/windows-install/)
- [Linux](https://docs.docker.com/engine/install/)
- [Mac](https://docs.docker.com/desktop/setup/install/mac-install/)

### Docker Compose
- Used for running multi-container applications
- [Install](https://docs.docker.com/compose/install/)

## Demo
- We will be following [this demo](https://www.jenkins.io/doc/tutorials/build-a-java-app-with-maven/)

### Phase 1 - Installing Jenkins

#### Fork + Clone Repo
- If we fork the repo we will have a copy of it in our own account
- From there, we can clone it to our local computer
- Navigate to the [repo](https://github.com/jenkins-docs/simple-java-maven-app)
- Click "Fork", select your account and confirm

#### Installing Jenkins
- Clone [repo](https://github.com/jenkins-docs/quickstart-tutorials)
  - Note that this is different than the one we forked
- In this repo, note the docker-compose.yml file. This will contain instructions for Docker and Docker compose to spin up our Jenkins program
- Run the command: `docker compose --profile maven up -d`

### Phase 2 - Setting up Pipeline
- Once Jenkins is installed, we can navigate to localhost:8080 in our browser
- When you first load up Jenkins, might need to create an account/sign up
  - "Now, log in using the admin username and admin password."

#### Creating the pipeline item:
- Pipeline contain instructions for how to build/test/etc. our project
- New Item -> Pipeline -> Give a Name for the pipeline
- Enter a description
- On the sidebar, find "Pipeline", click that
- Under definition, select "Pipeline script from SCM"
- In the "Repository URL" box, fill in the link of the repo that we forked earlier
- Don't change up the "Script Path" but make note if its default value, "Jenkinsfile"
- At this point, we have configured this Jenkins pipeline to look for the code at https://github.com/roryeiffe/simple-java-maven-app/tree/master 
- So, now we have to create the Jenkinsfile

### Phase 3 - Creating the Jenkinsfile
- The Jenkinsfile will contain instructions on how to run our pipeline (building, testing, etc.)

#### Jenkinsfile
- Create a file called "Jenkinsfile"
  - Note, no file extensions
- Place it at the root of our forked repository
  - Note that the location of the Jenkinsfile can be configured under the "Configure" menu when you go to the Pipeline
- Note the following about the Jenkinsfile
  - agent any - using any available agent (as opposed to specifying something like Docker) to run this pipeline
  - stages - note that we have a Build stage. We can also add multiple stages like testing, etc.
  - steps - including commands to run (in this case, packaging our app with Maven)
```
pipeline {
    agent any
    tools {
      maven 'Maven' // matches name in global tool configuration
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package' // mvn command to package our application. This should automatically run when we run the pipeline
            }
        }
    }
}
```
- Run the pipeline
  - Click "Build Now"
- Once the pipeline runs, we can inspect the console output, view the different stages, etc.
- Now that our development pipeline is automated, we can make changes to how we want things to run (ex: changing test report to a JSON) and, the next time we run the pipeline, we will see those changes
- Add the test stage:
```Jenkinsfile
stage('Test') {
    steps {
        bat 'mvn test'
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
```
- Can click "Build Now" to see the output

#### Final Jenkinsfile:
```
pipeline {
    agent any
    tools {
      maven 'Maven' // matches name in global tool configuration
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package' // mvn command to package our application. This should automatically run when we run the pipeline
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
          steps {
            bat 'echo "Delivering package to temporary staging environment"'
          }
        }
    }
}
```



### Troubleshooting
- "Cannot find 'nohup'
  - Solution: Use windows commands in the Jenkinsfile
  - Instead of ```bat 'mvn -B -DskipTests clean package'```, we use ```sh 'mvn -B -DskipTests clean package'```
  - **Make sure you commit changes again**
- 'mvn' command not recognized:
  - Verify that mvn is installed and path variables are correct
- On Jenkins, go to Dashboard -> Manage Jenkins -> Tools
- Scroll down to Maven
- Click "Add Maven"
- Fill out a name for this installation (remember this)
- Fill out the location for the Maven installation (ex: 'C:\apache-maven-3.9.9')
- Finally, update your Jenkinsfile accordingly:
```Jenkinsfile
pipeline {
    agent any
    // NEW STUFF:
    tools {
        maven 'Maven' // Match the name in Global Tool Configuration
    }
    // END NeW STUFF

    
    stages {
        stage('Build') { 
            steps {
                bat 'mvn -B -DskipTests clean package' 
            }
        }
    }
}
```