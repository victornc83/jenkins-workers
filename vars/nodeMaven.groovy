#!/usr/bin/groovy

def call(body){
    podTemplate(
        name: 'maven',
        label: 'maven',
        cloud: "kubernetes",
        namespace: "default",
        imagePullSecrets: [],
        envVars: [],
        containers: [
            containerTemplate(
                name: 'jnlp',
                image: 'victornc83/docker-maven-slave:latest',
                ttyEnabled: true,
                workingDir: '/tmp',
                args: '${computer.jnlpmac} ${computer.name}',
                envVars: []
            )
        ]
    ){
        node('maven'){
            body()
        }
    }
}
