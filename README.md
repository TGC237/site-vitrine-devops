# site-vitrine-devops
# 🏆 Projet Saint Graal : Site Vitrine & Infrastructure Industrielle

![DevOps](https://img.shields.io/badge/Culture-DevOps-blueviolet)
![Cloud-Native](https://img.shields.io/badge/Architecture-Cloud--Native-blue)
![Security](https://img.shields.io/badge/Security-DevSecOps-red)

Ce projet est une plateforme de démonstration d'ingénierie logicielle complète. Il combine un site vitrine moderne et une infrastructure de production automatisée, sécurisée et supervisée.

---

## 🏛️ Architecture de l'Infrastructure

L'infrastructure repose sur un paradigme **Cloud-Native** et **Agnostique**, conçu pour être déployé sur n'importe quel environnement Linux (VPS ou Cloud).



### Composants Clés :
* **Gateway & Sécurité :** Reverse Proxy **Nginx** avec terminaison SSL/TLS (DuckDNS & Certbot).
* **Compute :** Conteneurisation **Docker** (Isolation via réseaux Bridge privés).
* **CI/CD :** Pipeline automatisé sous **Jenkins** intégrant des audits de code **SonarQube**.
* **Observabilité :** Monitoring temps réel avec **Prometheus** et **Grafana**.
* **Gouvernance :** Gestion de l'orchestration via **Portainer**.

---

## 🚀 Fonctionnalités Techniques "Expert"

### 1. Docker Multi-stage Build (Optimisation)
Pour garantir la sécurité et la légèreté en production, nous utilisons une compilation en deux étapes :
- **Stage 1 (Build) :** Utilisation du JDK 21 pour compiler le bytecode Java.
- **Stage 2 (Runtime) :** Isolation du binaire dans une image JRE 17 Alpine (réduction de la surface d'attaque de 80%).

### 2. Isolation Réseau Zero-Trust
L'application n'est jamais exposée directement sur le Web public. Elle réside dans une **DMZ logicielle** (réseau Docker interne) où seul le Reverse Proxy Nginx a l'autorisation de router le trafic.

### 3. Pipeline DevSecOps
Chaque commit déclenche un cycle de vie automatisé :
`Git Push` ➔ `Jenkins Build` ➔ `SonarQube Scan` ➔ `Docker Image Push` ➔ `Continuous Deployment`.

---

## 🛠️ Stack Technique

| Domaine | Technologies |
| :--- | :--- |
| **OS / Cloud** | Debian 12, Linux Hardening |
| **Container** | Docker, Docker Compose, Portainer |
| **Automation** | Jenkins (Pipeline-as-Code), Maven |
| **Qualité** | SonarQube (SAST Analysis) |
| **Observabilité** | Prometheus, Grafana |
| **Sécurité** | Nginx, SSL/TLS, Certbot |

---

## 📦 Installation & Déploiement

### Prérequis
- Docker & Docker Compose installés.
- Un serveur Linux (Debian recommandé).

### Déploiement rapide
1. Cloner le dépôt :
   ```bash
   git clone [https://github.com/ton-username/saint-graal.git](https://github.com/ton-username/saint-graal.git)
   cd saint-graal

  Lancer l'infrastructure :

Bash
docker-compose up -d
Accéder au dashboard Portainer sur le port 9000 pour vérifier l'état des services.

📉 Observabilité & SRE
Le système est monitoré en continu.

Métriques : Accès via Grafana (Dashboard de santé système).

Résilience : Politiques de restart: always et healthchecks configurés pour l'auto-cicatrisation.

⚖️ Licence & Philosophie
Ce projet est sous licence MIT. Il a pour objectif de démontrer qu'une infrastructure complexe peut être rendue fiable par l'automatisation et la documentation rigoureuse.

"L'infrastructure est le code, et le code est la vérité."


---

### 💡 Conseils pour personnaliser ton README

1.  **Screenshots :** N'hésite pas à ajouter une capture d'écran de ton **Dashboard Grafana** ou de ton **Pipeline Jenkins**. Rien ne prouve mieux le succès technique qu'une image de "Build Success".
2.  **Badges :** Tu peux personnaliser les badges en haut du fichier avec des services comme [Shields.io](https://shields.io/).
3.  **Lien Live :** Si ton site est hébergé, ajoute un lien vers la démo en direct au tout début.

### 🏁 Prochaine étape

Cette vidéo explique en détail comment structurer un pipeline CI/CD moderne avec Jenkins, Docker et SonarQube, ce qui appuie parfaitement la partie technique de ton README. [Guide complet Jenkins Docker SonarQube](https://www.youtube.com/watch?v=cy90OTK4-Q0)


http://googleusercontent.com/youtube_content/0
