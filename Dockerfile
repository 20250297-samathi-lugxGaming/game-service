## Use official Java 21 (Debian-based)
#FROM openjdk:21-jdk
#
## Copy the built JAR into the container
#COPY target/game-service-0.0.1-SNAPSHOT.jar /app/app.jar
#
## Run the app
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]

FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]