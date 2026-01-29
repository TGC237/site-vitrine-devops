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
        	echo "Nettoyage de l'ancien container de secours..."
        	sh "docker rm -f site-copilot-backup || true"
        
      	  	echo "Lancement de la version Copilot sur le port 8081..."
        	sh "docker run -d --name site-copilot-backup -p 8081:80 vitrine-backup:latest"
    	    }
	}
    }
}
