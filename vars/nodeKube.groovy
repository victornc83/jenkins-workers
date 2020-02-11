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
                image: 'victornc83/kube-slave:1.0',
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
