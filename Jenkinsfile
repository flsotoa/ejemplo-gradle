pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps{
                script{
                    stage("Build & test") {
					//sh "gradlew clean build"
                    }
                    stage('SonarQube analysis') {
					def scannerHome = tool 'sonar';
					withSonarQubeEnv('sonar-fsa') { // If you have configured more than one global server connection, you can specify its name
					sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"}
                    }
                    stage("Run") {
                        //
                    }
                    stage("Rest") {
                        //
                    }
                    stage("Nexus") {
                        //
                    }
                }
            }
        }
    }
}
