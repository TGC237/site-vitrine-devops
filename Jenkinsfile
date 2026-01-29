pipeline {
    agent any
    stages {
        stage('Cleanup') {
            steps {
                sh "docker-compose down || true"
            }
        }
        stage('Docker Build Local') {
            steps {
                sh "docker build -t vitrine-backup:latest ."
            }
        }
        stage('Deploy Backup (Port 8081)') {
            steps {
                // On utilise docker-compose car tu as déjà configuré le port 8081 dedans
                sh "docker-compose up -d"
            }
        }
    }
}
