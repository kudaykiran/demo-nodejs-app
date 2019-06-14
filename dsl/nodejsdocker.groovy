job('NodeJS Docker Job created by DSL') {
    scm {
        git('git://github.com/samarth0157/demo-nodejs-app.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('SAMARTH')
            node / gitConfigEmail('samarth3112@live.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('mynodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('sam0157/jenkins-nodeimage')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
