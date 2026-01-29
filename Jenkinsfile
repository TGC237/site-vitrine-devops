pipeline {
    agent any
    stages {
        stage('Cleanup') {
            steps {
                // On tente de nettoyer via compose au cas où, mais on ne bloque pas si ça échoue
                sh "docker-compose down || true"
            }
        }
        stage('Docker Build Local') {
            steps {
                sh "docker build -t vitrine-backup:latest ."
            }
        }
        stage('Deploy Backup (Port 8082)') {
            steps {
                echo "Nettoyage de l'ancien container de secours..."
                sh "docker rm -f site-copilot-backup || true"

                echo "Lancement de la version Copilot sur le port 8082..."
                // Utilisation du port 8082 pour éviter le conflit avec Nexus sur le 8081
                sh "docker run -d --name site-copilot-backup -p 8082:80 vitrine-backup:latest"
		// AJOUTE CETTE LIGNE ICI :
                sh "docker network connect proxy-network site-copilot-backup || true"
            }
        }
    }
}
