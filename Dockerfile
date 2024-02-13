# Étape de construction des tests unitaires
FROM maven:3.8.3-openjdk-17 AS test
COPY . .
RUN mvn test


FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package 
FROM openjdk:17-ea-28-jdk-slim
COPY --from=build /target/back-0.0.1-SNAPSHOT.jar back.jar
EXPOSE 9090
ENTRYPOINT [ "java","-jar","back.jar" ]