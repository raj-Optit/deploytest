def deployToKubernetes(kubeConfig, namespace, deploymentPath, servicePath) {
    withEnv(["KUBECONFIG=${kubeConfig}"]) {
        // Apply deployment and service YAML files to the specified namespace
        sh "kubectl apply -f ${deploymentPath} --namespace ${namespace} --validate=false"
        sh "kubectl apply -f ${servicePath} --namespace ${namespace} --validate=false"
    }
}

return this
