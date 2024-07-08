pipeline {
    agent any

    triggers {
        // Запускать каждый день в полночь
        cron('H 0 * * *')
    }

    stages {
        stage('Periodic Task') {
            steps {
                echo 'Running periodic task...'
            }
        }
    }
}