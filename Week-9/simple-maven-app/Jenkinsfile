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