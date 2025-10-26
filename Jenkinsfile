pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {

                git branch: 'master', credentialsId: '12345', url: 'https://github.com/jhans10/product_crud.git'

                sh 'ls -la'
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
                 sh 'docker run -d -p 0:8081 --name product-crud-container product-crud'

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
