pipeline {
    agent any

    environment {
        DOCKER_PASSWORD='jen-doc-hu'
        DOCKER_REGISTRY = 'ermukeshmahato'  // Docker registry URL (e.g., Docker Hub or AWS ECR)
        FRONTEND_IMAGE = 'demo-frontend'
        BACKEND_IMAGE = 'demo-backend'
        IMAGE_TAG='v1.0.0'
        MYSQL_IMAGE = 'mysql:8'
        
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[credentialsId: 'gittoken', url: 'https://github.com/er-mukeshmahato/Automation-devops']])
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                   
                    // Build backend Docker image
                  //  sh 'docker build -t $DOCKER_REGISTRY/$BACKEND_IMAGE ./banking-api'
                       docker.build("${FRONTEND_IMAGE}:${IMAGE_TAG}", "-f bank-frontend/Dockerfile bank-frontend")
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script {
                    // Login to Docker Hub using the Jenkins credentials
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                         docker.image("${FRONTEND_IMAGE}:${IMAGE_TAG}").push()
                    }
                }
            }
        }


        stage('Deploy to Kubernetes') {
            steps {
                script {
                    kubeconfig(caCertificate: 'LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSURCVENDQWUyZ0F3SUJBZ0lJRmJMd2NMbUF0d013RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TlRBeE1UQXhPRE0xTVRGYUZ3MHpOVEF4TURneE9EUXdNVEZhTUJVeApFekFSQmdOVkJBTVRDbXQxWW1WeWJtVjBaWE13Z2dFaU1BMEdDU3FHU0liM0RRRUJBUVVBQTRJQkR3QXdnZ0VLCkFvSUJBUURYM2hoOHJVUFBLTDNUcnVscXhEeGdEWkV3MHFNa1B0OG5aNTNoUVY2cjVFQzcya0dFS3dZOVJqUnAKczMzSGFWUWNFZ3NyTTZHT083M3VDVmdzMHp6Y2p6OEFOUWtUSXIrVndyUjZTT0p2QnFRNkt3dVpVK2locXpUMAoyQVE2eHNQTWlHVkZDWmlXUE1wWUF4R213Qlk5cGNqdnRiK25XRE16VW5UcDRESmZTVnZJVmFjNzdxekF6N0dOCkUzZmNUeUo4US9sQ2pNKzZ5WWFSUGQwZ1ZvSVpORUgyWjBvNXJOVXVjeEYrM2JYa0NRcllnUGZTalVyOEZsUXUKNTZIaXdOQTB6UHZWTDRyZUwwbGJ6VmtOT3IrNFJYYTBKZVM4cHJEdXgzWVB4RU9rOUFsRGlvTjRWZElIYXl0Vgp6b1hWSG1uaElFaXJ4Q2NzQVNyNkFieTJOZGliQWdNQkFBR2pXVEJYTUE0R0ExVWREd0VCL3dRRUF3SUNwREFQCkJnTlZIUk1CQWY4RUJUQURBUUgvTUIwR0ExVWREZ1FXQkJRZktlWEc5Vk5paDE3RzVGRy9zZld1bFZqeWV6QVYKQmdOVkhSRUVEakFNZ2dwcmRXSmxjbTVsZEdWek1BMEdDU3FHU0liM0RRRUJDd1VBQTRJQkFRQlJhMDdNc3k3egp0bTRWcGFIbTFXZ0s3TjFlc1JMQlFtV0FlSmFiSFRhdVk4Zm5JaVNyMnp4SlVsVjJkTXZhb2VUR0QyVVl3Y3dxCk1hMCt5SUJ6VE1KTWJoeXUvcTFtRUx4SXJCTVFHK2o0Z0hTbDdNQ2JDWHE3YzlwZVFZRmRsU01VVnBoRWxMbkUKSnFtTGwxM0J6Qlp6S2dOSXB6bHB5eXY1ZW04TW93c2JINWZxd0ZpNFZWclNYMzErb1ZRSUNNZGVSN3F5Y1c1MApKVW15SjRwUWY3dVlRQm1pTWRBQmo3a0lzMXJDSjd6SFRHd0VTNFJzdXpaTDI1UlAxSk12eFBPKzgvcTZLa2tMCkY0Vis4eFBvbW9BT3FCRm9YNG13WEVIcURIancxRGJMbmVhL1l3SU9LSDdoNGkwbUZlbDAzOWZNWit4SGNsOEgKWkdpRHdBbjBRVVRBCi0tLS0tRU5EIENFUlRJRklDQVRFLS0tLS0K', credentialsId: 'kubeconfig', serverUrl: ' https://127.0.0.1:56446') {
                    // some block
                     }

                    // Deploy backend service
                    sh 'kubectl apply -f kubernetes/frontend-deployment.yml'

                 
                   
                }
            }
        }

        stage('Verify Deployment') {
            steps {
                script {
                    // Wait for the deployments to finish (you can replace this with a specific wait time or checks)
                    sh 'kubectl rollout status deployment/k8s-deployment'
                }
            }
        }

        stage('Clean Up') {
            steps {
                script {
                   
                    sh 'kubectl delete deployment k8s-deployment --ignore-not-found=true'
                }
            }
        }
    }

    post {
        always {
            // Clean workspace after build
            cleanWs()
        }
    }
}
