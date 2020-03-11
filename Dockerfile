FROM java
COPY target/rest-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "rest-service-0.0.1-SNAPSHOT.jar"]