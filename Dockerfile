FROM openjdk:17
COPY pcs-core/target/pcs-core-0.0.1-SNAPSHOT.jar /app/pcs-core-0.0.1-SNAPSHOT.jar
COPY pcs-client/target/pcs-client-0.0.1-SNAPSHOT.jar /app/pcs-client-0.0.1-SNAPSHOT.jar
COPY pcs-service/target/pcs-service-0.0.1-SNAPSHOT.jar /app/pcs-service-0.0.1-SNAPSHOT.jar
COPY pcs-api/target/pcs-api-0.0.1-SNAPSHOT.jar /app/pcs-api-0.0.1-SNAPSHOT.jar
COPY pcs-persistence/target/pcs-persistence-0.0.1-SNAPSHOT.jar /app/pcs-persistence-0.0.1-SNAPSHOT.jar

WORKDIR /app
CMD ["java", "-jar", "pcs-api-0.0.1-SNAPSHOT.jar"]
