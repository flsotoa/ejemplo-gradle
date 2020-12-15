pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps{
                script{
                    stage("Build & test") {
			sh "gradlew clean build"
                    }
                    stage('SonarQube analysis') {
    			def scannerHome = tool 'sonar-fsa';
    			withSonarQubeEnv('sonar-fsa) {
      			sh "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
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