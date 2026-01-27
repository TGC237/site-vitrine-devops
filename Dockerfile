#<!-- # On part d'une version légère de Java 17
#FROM eclipse-temurin:17-jre-alpine

#WORKDIR /app

# On utilise un wildcard pour être sûr de trouver le jar, 
# peu importe son nom exact dans le dossier target
#COPY target/*-RELEASE.jar /app/app.jar

# On s'assure que le fichier est lisible
#RUN chmod 644 /app/app.jar

#EXPOSE 8080

# On lance avec le chemin complet
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# ÉTAPE 1 : Compilation (Le Builder)
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# On compile le JAR directement ici
RUN mvn clean package -DskipTests

# ÉTAPE 2 : Exécution (L'Image finale)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# On récupère le JAR généré à l'étape 1
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
