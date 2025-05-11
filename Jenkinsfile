pipeline {
    agent any

    environment {
        IMAGE_NAME      = 'spring-boot-tomcat'
        CONTAINER_NAME  = 'dashboard-container'
        HOST_PORT       = '9090'
        CONTAINER_PORT  = '8080'
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

        stage('Stop Previous Container') {
            steps {
                echo "🛑 Stopping and removing old container (if exists)..."
                sh """
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true
                """
            }
        }

        stage('Run New Container') {
            steps {
                echo "🚀 Running new container..."
                sh "docker run -d --name ${CONTAINER_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo '✅ Deployment successful!'
        }
        failure {
            echo '❌ Deployment failed.'
        }
    }
}
