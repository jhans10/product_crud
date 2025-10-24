pipeline {
    agent any
    tools {
        maven 'Maven-3.9'
        jdk 'jdk21'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github-cred', url: 'https://github.com/tuusuario/springboot-ci-demo.git'
            }
        }
        stage('Build') {
            steps {
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
