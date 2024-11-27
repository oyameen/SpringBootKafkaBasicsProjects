FROM maven:3.9.9-eclipse-temurin-21-alpine AS base

WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn install -DSkipTest


FROM base AS build

WORKDIR /application

COPY --from=base /app/target/SpringBootKafkaBasics-1.0.jar output/app.jar
COPY --from=base /app/src/main/resources/application.properties config/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/application/output/app.jar"]