pipeline {
    agent any
    tools {
        maven 'Maven-3.9'
        jdk 'jdk21'
    }
    stages {
        stage('Checkout') {
            steps {
            cleanWs()
                git branch: 'main', credentialsId: '12345', url: 'https://github.com/jhans10/product_crud.git'
            }
        }

        stage('Build') {
            steps {
                    sh 'chmod +x mvnw || true'     // ✅ asegurar permisos de ejecución del wrapper
                          sh './mvnw clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Desplegando aplicación Spring Boot (simulado)'
            }
        }
    }
    post {
        success {
            echo 'Pipeline ejecutado correctamente ✅'
        }
        failure {
            echo 'Pipeline falló ❌'
        }
    }
}
