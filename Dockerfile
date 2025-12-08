# Basis-Image: OpenJDK 17 (oder 21, falls dein Projekt 21 nutzt)
FROM eclipse-temurin:21-jdk

# Arbeitsverzeichnis im Container
 WORKDIR /app

 # JAR-Datei kopieren (nach Maven-Build)
 COPY target/demo_Apod-0.0.1-SNAPSHOT.jar app.jar

 # Port, den Spring Boot verwendet
 EXPOSE 8080

 # Start-Befehl
 ENTRYPOINT ["java", "-jar", "app.jar"]
