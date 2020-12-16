pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps{
                script{
                    stage("Build & test") {
			sh "gradle build"
                    }
                    stage('SonarQube analysis') {
			def scannerHome = tool 'sonar';
			withSonarQubeEnv('sonar-fsa') {
			bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
			}
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
