#!/usr/bin/groovy

def call(body){
    podTemplate(
        name: 'slave',
        label: 'slave',
        cloud: "kubernetes",
        namespace: "default",
        imagePullSecrets: [],
        envVars: [],
        containers: [
            containerTemplate(
                name: 'jnlp',
                image: 'victornc83/jnlp-slave:latest',
                ttyEnabled: true,
                workingDir: '/tmp',
                args: '${computer.jnlpmac} ${computer.name}',
                envVars: []
            )
        ]
    ){
        node('slave'){
            body()
        }
    }
}
