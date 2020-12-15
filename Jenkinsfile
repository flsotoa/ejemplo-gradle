pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps{
                script{
                    stage("Build & test") {
                        //
                    }
                    stage('SonarQube analysis') {
    			def scannerHome = tool 'SonarScanner 4.0';
    			withSonarQubeEnv('My SonarQube Server') {
      			sh "$C:\\Users\\Flavio\\Downloads\\Downloads\\Universidad\\DiplomadoDevOpsUSACH\\Clases\\Unidad_3\\sonarqube-8.5.1.38104\				\sonarqube-8.5.1.38104\\bin\\sonar-scanner"
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
