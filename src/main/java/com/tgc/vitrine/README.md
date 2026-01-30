# 🛰️ TGC Mission Control - DevSecOps Dashboard

Ce projet est une interface de pilotage **Full-Stack** conçue pour surveiller en temps réel la santé d'une infrastructure distribuée (9 sites DuckDNS, Pipeline CI/CD, et ressources serveur).

## 🏗️ Architecture du Système

Le monitoring repose sur une chaîne de données automatisée :
1. **Sondes** : `Prometheus` + `Blackbox Exporter` (HTTP & SSL) + `Node Exporter` (RAM).
2. **ETL (Logic)** : `n8n` récupère les métriques, calcule la validité SSL et détecte les pannes.
3. **Persistance** : `PostgreSQL` stocke l'état actuel (ID: 1) pour une lecture rapide.
4. **Backend** : `Java Spring Boot` (JPA/Hibernate) expose les données via une API REST.
5. **Frontend** : Interface `HTML5/JS` (Thymeleaf + TailwindCSS) avec rafraîchissement dynamique.

## 🛠️ Composants Java (Backend)

L'architecture Java suit le pattern **MVC** :
* **Model (`Dashboard.java`)** : Entité JPA mappée sur la table `dashboard`. Inclut les champs `site_status` et `ram_usage_gb`.
* **Repository (`DashboardRepository.java`)** : Interface utilisant une native query pour récupérer l'état instantané (`ID=1`).
* **Controller (`MainController.java`)** : 
    * Sert la vue principale via Thymeleaf.
    * Expose le endpoint `/data/mission_control.json` pour le rafraîchissement asynchrone (AJAX).



## 📊 Indicateurs de Supervision

Le dashboard affiche trois états critiques pour les services :
* 🟢 **ALL ONLINE** : Tous les services répondent avec un code HTTP 200.
* 🟠 **SSL WARN** : Infrastructure opérationnelle, mais un certificat expire dans moins de 20 jours.
* 🔴 **X DOWN** : Un ou plusieurs services sont injoignables (ex: `tgc-jenkins`).

## 🚀 Installation et Déploiement

### Prérequis
* Java 17+
* PostgreSQL
* Un flux n8n actif pour alimenter la base de données

### Compilation
```bash
./mvnw clean package -DskipTests

Exécution
Bash
java -jar target/vitrine-0.0.1-SNAPSHOT.jar
📝 Configuration n8n (Query Prometheus)
Pour le bon fonctionnement du monitoring, le nœud HTTP Request de n8n doit utiliser la requête suivante : {__name__=~"jenkins_job_count_value|node_memory_MemAvailable_bytes|probe_success|probe_ssl_earliest_cert_expiry"}

Développé par Giresse Cédric - Ingénieur DevSecOps
