FROM openjdk:11
EXPOSE 8082
CMD ["java", "-jar", "rest-service-0.0.1-SNAPSHOT.jar"]

COPY target/rest-service-0.0.1-SNAPSHOT.jar .