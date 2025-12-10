# Stage 1: Build
FROM eclipse-temurin:17-jdk-focal AS build
WORKDIR /app
COPY . .

# mvnw ausführbar machen
RUN chmod +x mvnw

# Maven Build
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/demo_Apod-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
