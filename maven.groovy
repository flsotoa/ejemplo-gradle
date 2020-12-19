
/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
            stage("Build") {
		    env.TAREA =env.STAGE_NAME
                    sh 'mvn clean compile -e'
            }
            stage("Test") {
		env.TAREA =env.STAGE_NAME
                sh 'mvn clean test -e'
            
            }
            stage("Jar") {
		env.TAREA =env.STAGE_NAME
		sh 'mvn.cmd clean package -e'
                
            }
            stage("SonarQube") {
		env.TAREA =env.STAGE_NAME
                withSonarQubeEnv(installationName: 'sonar-fsa') {
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'                 }
             }
	    stage("Run Jar") {
		env.TAREA =env.STAGE_NAME
                sh 'mvn spring-boot:run &'
                    }
            stage("Sleep") {
		env.TAREA =env.STAGE_NAME
                sh 'sleep 200'
		}
	    stage("Testing_aplication") {
		env.TAREA =env.STAGE_NAME
                sh 'curl -X GET http://localhost:8085/rest/mscovid/test?msg=testing'
                    }
            stage("Upload Nexus") {
		env.TAREA =env.STAGE_NAME
                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/Users/nicolas/code/estudios/usach/unidad3/forks/ejemplo-maven/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]

            }
}

return this;
