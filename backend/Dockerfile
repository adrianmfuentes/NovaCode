# Build stage
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY lib ./lib
RUN mvn install:install-file -Dfile=./lib/introspector-1.2.jar -DgroupId=uniovi.dlp -DartifactId=introspector -Dversion=1.2 -Dpackaging=jar && \
    mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
