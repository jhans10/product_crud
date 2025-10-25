pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                cleanWs()
                git branch: 'main', credentialsId: '12345', url: 'https://github.com/jhans10/product_crud.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t product-crud .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker rm -f product-crud-container || true'
                sh 'docker run -d --name product-crud-container -p 8081:8081 product-crud'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Quarkus Docker image built & running'
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline ejecutado correctamente"
        }
        failure {
            echo "❌ Pipeline falló"
        }
    }
}
