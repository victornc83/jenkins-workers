#!/usr/bin/groovy

def call(body){
    podTemplate(
        name: 'ansible',
        label: 'ansible',
        cloud: "kubernetes",
        namespace: "default",
        imagePullSecrets: [],
        envVars: [],
        containers: [
            containerTemplate(
                name: 'jnlp',
                image: 'victornc83/ansible-slave:latest',
                ttyEnabled: true,
                workingDir: '/tmp',
                args: '${computer.jnlpmac} ${computer.name}',
                envVars: []
            )
        ]
    ){
        node('ansible'){
            body()
        }
    }
}
