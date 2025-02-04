pipeline {
    agent any

    environment {
        // Define the frontend image with the repository name and build ID
        DOCKER_HUB_REPO = 'ermukeshmahato/demo-react-app'
        DOCKER_REGISTRY = 'https://hub.docker.com/u/ermukeshmahato'
        DOCKER_HUB_CREDENTIALS_ID = 'dockerhubjenkins'
    }
     
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the Git repository
                checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[credentialsId: 'git-jenkins-token', url: 'https://github.com/er-mukeshmahato/Automation-devops']])
            }
        }
        stage('Build Frontend Docker Image') {
            steps {
                dir('bank-frontend') {
                    script {
                        // Build the frontend Docker image with the unique build ID
                        dockerImage = docker.build("${DOCKER_HUB_REPO}:latest")
                    }
                }
            }
        }

        stage('Push Frontend Docker Image') {
            steps {
                script {
                    // Push the frontend Docker image to Docker Hub
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-token') {
                        dockerImage.push('latest')
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                dir('kubernetes') {
                    script {
                        // Use the kubeconfig credentials to interact with Kubernetes
                        kubeconfig(credentialsId: 'minikube-k8s-credentials', serverUrl: 'http://127.0.0.1:51684') {
                            bat 'kubectl version'
                            bat 'kubectl apply -f demo-react.yaml'
                            
                            bat 'kubectl rollout restart deployment demo-react-app-deployment'

                            // Wait for the rollout to finish
                            bat 'kubectl rollout status deployment demo-react-app-deployment'
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Frontend Deployment Successful! Build ID: ${BUILD_ID}"
        }
        failure {
            echo "Frontend Deployment Failed! Build ID: ${BUILD_ID}"
        }
    }
}
