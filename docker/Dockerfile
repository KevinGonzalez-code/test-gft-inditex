FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/inditex-prices-0.0.1-SNAPSHOT.jar ./inditex-prices.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/inditex-prices.jar"]
