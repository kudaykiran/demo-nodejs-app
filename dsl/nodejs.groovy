job('NodeJS jobdsl') {
    scm {
        git('git://github.com/samarth0157/demo-nodejs-app.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('TestUser')
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
        shell("npm install")
    }
}
