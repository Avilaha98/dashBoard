pipeline {
    agent any

    environment {
        IMAGE_NAME      = 'abhijitlaha/proddeployment'
        CONTAINER_NAME  = 'dashboard-container'
        HOST_PORT       = '9090'
        CONTAINER_PORT  = '8080'
        DOCKER_USER     = 'abhijitlaha'
        DOCKER_PASS     = '8945598722@Avi'  // ⚠️ Hardcoded password here
    }

    stages {
        stage('Build WAR with Maven') {
            steps {
                echo '🔧 Building WAR file...'
                script {
                    docker.image('maven:3.9.6-eclipse-temurin-17').inside {
                        sh 'mvn clean package -DskipTests'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "🐳 Building Docker image..."
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Docker Login & Push') {
            steps {
                echo "🔐 Logging in and pushing image to Docker Hub..."
                sh """
                    echo '${DOCKER_PASS}' | docker login -u '${DOCKER_USER}' --password-stdin
                    docker push ${IMAGE_NAME}
                    docker logout
                """
            }
        }

        stage('Stop Previous Container') {
            steps {
                echo "🛑 Stopping and removing old container (if exists)..."
                sh """
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true
                """
            }
        }

        stage('Run New Container from Docker Hub') {
            steps {
                echo "🚀 Running new container from Docker Hub..."
                sh "docker pull ${IMAGE_NAME}"
                sh "docker run -d --name ${CONTAINER_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo '✅ Deployment successful and pushed to Docker Hub!'
        }
        failure {
            echo '❌ Deployment failed.'
        }
    }
}
