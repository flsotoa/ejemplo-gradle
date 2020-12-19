pipeline {
    agent any

    parameters { choice(name: 'herramienta', choices: ['gradle', 'maven'], description: '') }
    stages {
        stage('Pipeline') {
            steps {
                script {
                    	env.TAREA = ''
                   	echo params.herramienta
                	if (params.herramienta == 'gradle') {
                        def ejecucion = load 'gradle.groovy'
                        ejecucion.call()
                	}	
			else {
                    	 def ejecucion = load 'maven.groovy'
                      	ejecucion.call()
                    }
                }
            }
        }
    }
	post{	
		success{
			slackSend color: 'good', message: "[Flavio Soto Aburto] [${env.JOB_NAME}] [${env.HERRAMIENTA}] - Ejecución exitosa', teamDomain: 'devops-usach-2020', tokenCredentialId: 'slack-token'
		}
		failure{
			slackSend color: 'danger', message: "[Flavio Soto Aburto] [${env.JOB_NAME}] [${env.HERRAMIENTA}] - Ejecución fallida en stage [${env.STAGE_NAME}], teamDomain: 'devops-usach-2020', tokenCredentialId: 'slack-token'
		}
	}
}
