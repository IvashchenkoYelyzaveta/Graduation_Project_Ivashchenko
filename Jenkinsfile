pipeline {
    agent any

    triggers {
        cron('H 0 * * *') // Запускать каждый день в полночь
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat '"C:\\Program Files\\apache-maven-3.9.7\\bin\\mvn" clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing...'
                bat '"C:\\Program Files\\apache-maven-3.9.7\\bin\\mvn" test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                echo 'Generating Allure Report...'
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']] // Путь к результатам Allure
                ])
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!' // Сообщение при успешном завершении
        }
        failure {
            echo 'Pipeline failed.' // Сообщение при сбое
        }
    }
}