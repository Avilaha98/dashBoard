pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            args '-v /var/run/docker.sock:/var/run/docker.sock' // To allow Docker commands
        }
    }

    environment {
        IMAGE_NAME      = 'spring-boot-tomcat'
        CONTAINER_NAME  = 'dashboard-container'
        HOST_PORT       = '9090'
        CONTAINER_PORT  = '8080'
    }

    stages {

        stage('Clone from Git') {
            steps {
                echo '📥 Cloning repository...'
                checkout scm
            }
        }

        stage('Build WAR with Maven') {
            steps {
                echo '🔧 Building WAR file...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "🐳 Building Docker image..."
                script {
                    try {
                        sh "docker build -t ${IMAGE_NAME} ."
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
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
                script {
                    try {
                        sh "docker run -d --name ${CONTAINER_NAME} -p ${HOST_PORT}:${CONTAINER_PORT} ${IMAGE_NAME}"
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }
    }

    post {
        success {
            echo '✅ Deployment successful!'
        }
        failure {
            echo '❌ Deployment failed.'
            // Add further cleanup or notifications here if needed.
        }
        always {
            echo "🧹 Cleanup actions (if any)"
            // Optionally perform cleanup or send notifications
        }
    }
}
