# Etapa 1: Compilar
FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar el .jar
FROM eclipse-temurin:17-jdk
COPY --from=build /app/target/api-productos-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
