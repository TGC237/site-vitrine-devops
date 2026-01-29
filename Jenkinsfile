pipeline {
    agent any

    environment {
        // On définit le nom spécifique pour ne pas écraser ton cockpit
        IMAGE_NAME = "vitrine-backup"
        NEXUS_REGISTRY = "tgc-nexus.duckdns.org" 
        // Remplace par l'URL exacte de ton repo Nexus si besoin
        NEXUS_REPO = "repository/docker-private/" 
    }

    stages {
        stage('Checkout Backup') {
            steps {
                // Jenkins récupère déjà le code via la config du Job
                echo "Récupération de la version Copilot..."
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    echo "Construction de l'image de secours..."
                    sh "docker build -t ${IMAGE_NAME}:latest ."
                }
            }
        }

        stage('Push to Nexus') {
            steps {
                script {
                    echo "Envoi de la version Backup vers Nexus..."
                    // On ajoute le tag pour Nexus
                    sh "docker tag ${IMAGE_NAME}:latest ${NEXUS_REGISTRY}/${NEXUS_REPO}${IMAGE_NAME}:latest"
                    
                    // Connexion et Push (utilise tes credentials Jenkins pour Nexus)
                    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PWD')]) {
                        sh "echo ${NEXUS_PWD} | docker login ${NEXUS_REGISTRY} -u ${NEXUS_USER} --password-stdin"
                        sh "docker push ${NEXUS_REGISTRY}/${NEXUS_REPO}${IMAGE_NAME}:latest"
                    }
                }
            }
        }

        stage('Deploy Backup (Port 8081)') {
            steps {
                echo "Lancement du container de secours sur le port 8081..."
                sh "docker-compose up -d"
            }
        }
    }
}
