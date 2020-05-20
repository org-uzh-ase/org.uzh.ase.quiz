FROM openjdk:11
EXPOSE 8082
CMD ["java", "-Dspring.profiles.active=cloud", "-jar", "rest-service-0.0.1-SNAPSHOT.jar"]

COPY target/rest-service-0.0.1-SNAPSHOT.jar .
COPY src/main/resources/application-cloud.properties /
RUN mv application-cloud.properties config.properties