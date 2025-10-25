pipeline {
    agent {
        docker {
            image 'maven:3.9.9-eclipse-temurin-21'
            args '-v $HOME/.m2:/root/.m2'
        }
    }

    stages {

        stage('Checkout') {
            steps {
                cleanWs()
                git branch: 'main', credentialsId: '12345', url: 'https://github.com/jhans10/product_crud.git'
            }
        }

        stage('Build App JAR inside Dockerfile') {
            steps {
                sh 'docker build -t product-crud .'
            }
        }

        stage('Run Container Test') {
            steps {
                sh 'docker run -d -p 8081:8081 --name product-crud-container product-crud'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Imagen Docker de Quarkus construida y ejecutada correctamente'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline ejecutado correctamente'
        }
        failure {
            echo '❌ Pipeline falló'
        }
    }
}
