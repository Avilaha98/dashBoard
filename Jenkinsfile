pipeline {
    agent any

    environment {
        IMAGE_NAME = 'spring-boot-tomcat'   // Updated image name
        CONTAINER_NAME = 'dashboard-container'
        HOST_PORT = '9090'                  // Running on port 9090
        CONTAINER_PORT = '8080'             // Tomcat default port
    }

    stages {

        stage('Clone from Git') {
            steps {
                echo 'Cloning repository...'
                checkout scm
            }
        }

        stage('Build WAR with Maven') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Stop Previous Container') {
            steps {
                echo "Stopping and removing old container (if exists)..."
                sh """
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true
                """
            }
        }

        stage('Run New Container') {
            steps {
                echo "Running new container..."
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
