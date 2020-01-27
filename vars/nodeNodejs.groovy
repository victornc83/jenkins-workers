#!/usr/bin/groovy

def call(body){
    podTemplate(
        name: 'nodejs',
        label: 'nodejs',
        cloud: "kubernetes",
        namespace: "default",
        imagePullSecrets: [],
        envVars: [],
        containers: [
            containerTemplate(
                name: 'jnlp',
                image: 'victornc83/docker-nodejs-slave:8.14.0-alpine',
                ttyEnabled: true,
                workingDir: '/tmp',
                args: '${computer.jnlpmac} ${computer.name}',
                envVars: []
            )
        ]
    ){
        node('nodejs'){
            body()
        }
    }
}
