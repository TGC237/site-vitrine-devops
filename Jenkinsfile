pipeline {
    agent any
    stages {
        stage('Cleanup') {
            steps {
                sh "docker rm -f site-copilot-backup || true"
            }
        }
        stage('Docker Build Local') {
            steps {
                sh "docker build -t vitrine-backup:latest ."
            }
        }
        stage('Deploy Backup (Secure)') {
            steps {
                echo "Lancement sécurisé sur 127.0.0.1:8082..."
                // On ajoute 127.0.0.1: devant le port pour l'isoler
                sh "docker run -d --name site-copilot-backup -p 127.0.0.1:8082:80 vitrine-backup:latest"
                
                echo "Connexion au réseau proxy-network..."
                sh "docker network connect proxy-network site-copilot-backup || true"
            }
        }
    }
}
