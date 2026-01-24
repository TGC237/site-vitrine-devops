# On part d'une version légère de Java 17
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# On utilise un wildcard pour être sûr de trouver le jar, 
# peu importe son nom exact dans le dossier target
COPY target/*.jar /app/app.jar

# On s'assure que le fichier est lisible
RUN chmod 644 /app/app.jar

# On lance avec le chemin complet
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
