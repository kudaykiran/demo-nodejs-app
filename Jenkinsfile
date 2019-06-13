node {

     def commit_id
     stage('Preparation')
     checkout scm
     sh "git rev-parse --short HEAD > commit-id"
     commit_id = readFile('commit-id').trim()
     }
     
     stage('test'){
      nodejs(NodeJSInstallationName: 'mynodejs') {
      sh 'npm install --only=dev'
      sh 'npm test'
      }
     }
     stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
       def app = docker.build("sam0157/jenkins-nodeimage:${commit_id}", '.').push()
     }
   }
}
