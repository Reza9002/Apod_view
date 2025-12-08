# Stage 1: Build-Umgebung
FROM eclipse-temurin:17-jdk-focal AS build
WORKDIR /app
COPY . .

# Ausführung des Maven Builds
# Stellen Sie sicher, dass 'mvnw' (Maven Wrapper) vorhanden ist, oder ersetzen Sie es durch 'mvn'
RUN ./mvnw clean package -DskipTests

# Stage 2: Laufzeit-Umgebung
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

# ----------------------------------------------------------------------
# !!! HIER IST DIE WICHTIGE ANPASSUNG FÜR IHR PROJEKT !!!
# Nehmen wir an, Ihre JAR-Datei heißt: liebrica-21-0.0.1-SNAPSHOT.jar
# BITTE PRÜFEN SIE DEN EXAKTEN NAMEN IM 'target' ORNDER.
# ----------------------------------------------------------------------
COPY --from=build /app/target/liebrica-21-0.0.1-SNAPSHOT.jar app.jar

# Port-Definition (oft 8080 für Spring Boot)
EXPOSE 8080

# Starte die Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]