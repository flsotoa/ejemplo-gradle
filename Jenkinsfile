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
			slackSend message: ' [Flavio Soto][println env.JOB_NAME][params.buildtool]-Ejecución exitosa', teamDomain: 'devops-usach-2020', tokenCredentialId: 'slack-token'
		}
		failure{
			slackSend message: '[Flavio Soto][env.JOB_NAME][println params.buildtool]-Ejecución fallida en stage [env.STAGE_NAME]', teamDomain: 'devops-usach-2020', tokenCredentialId: 'slack-token'
		}
	}
}
