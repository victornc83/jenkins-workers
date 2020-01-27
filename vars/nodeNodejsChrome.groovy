#!/usr/bin/groovy

def call(body){
    podTemplate(
        name: 'nodejs-chrome',
        label: 'nodejs-chrome',
        cloud: "kubernetes",
        namespace: "default",
        imagePullSecrets: [],
        envVars: [],
        containers: [
            containerTemplate(
                name: 'jnlp',
                image: 'victornc83/jenkins-slave-nodejs-centos7:latest',
                ttyEnabled: true,
                workingDir: '/tmp',
                args: '${computer.jnlpmac} ${computer.name}',
                envVars: []
            )
        ]
    ){
        node('nodejs-chrome'){
            body()
        }
    }
}
