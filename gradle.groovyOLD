
/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
        stage("Build & test") {
		env.TAREA =env.STAGE_NAME
		sh "gradle clean build"
                    }
        stage("SonarQube analysis") {
		env.TAREA =env.STAGE_NAME
		def scannerHome = tool 'sonar';
		withSonarQubeEnv('sonar-fsa') {
		bat "${scannerHome}\\bin\\sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
	}
                    }
        stage("Run") {
		env.TAREA =env.STAGE_NAME
		sh "gradle bootRun &"
                    }
	stage("Sleep") {
		env.TAREA =env.STAGE_NAME
		 sh "sleep 200"
                  }	
        stage("Tes_Rest") {
		env.TAREA =env.STAGE_NAME
		sh "curl -X GET localhost:8085/rest/mscovid/test?msg=testing -O  && dir"
		sh "sleep 100"
                    }
		stage("Upload Nexus") {
		env.TAREA =env.STAGE_NAME
		nexusPublisher nexusInstanceId: 'Nexus',
		nexusRepositoryId: 'test-nexus',
		packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: 'C:\\Users\\Flavio\\.jenkins\\workspace\\job-nexus\\DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '0.0.1']]]
            }
}
return this;
