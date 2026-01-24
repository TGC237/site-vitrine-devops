# On part d'une version légère de Java 17
FROM openjdk:17-jdk-slim

# On crée un dossier pour l'application
WORKDIR /app

# On copie le fichier compilé par Jenkins (le .jar) dans l'image
# L'argument JAR_FILE sera passé par Jenkins
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# La commande pour démarrer le site
ENTRYPOINT ["java","-jar","/app.jar"]
