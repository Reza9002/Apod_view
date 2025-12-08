# Basis-Image: OpenJDK 17 slim
FROM openjdk:17-jdk-slim

# Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere das gebaute Jar in den Container
COPY target/demo_Apod-0.0.1-SNAPSHOT.jar app.jar

# Exponiere Port 8080 (Standard Spring Boot)
EXPOSE 8080

# Starte die Spring Boot App
ENTRYPOINT ["java", "-jar", "app.jar"]
