# Quiz Microservice
Microservice responsible for putting together a quiz object used in the frontend. For an API specification see [Swagger](https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1).

## Getting started
### Prerequisites
- Java 11
- Maven
- Running MongoDB, to define connection details see `application-local.properties` if you are running JAR, or `application-cloud.properties` if you are using containers. The files are in `src/main/resources`. The database should contain data, that you can import from `src/main/resources/movies`, see [How to import data](##How-to-import-data-into-MongoDB) for more info.


### Running
We do not provide precompiled JARs, but you can use our pre-built container from [DockerHub](https://hub.docker.com/repository/docker/vladmasarik/candidates). If you are looking for JAR file, you need to build one yourself, see [building guide](##Building).
After you are done with building simply execute the JAR, for example:
```
java -jar target/rest-service-0.0.1-SNAPSHOT.jar
```
or in case of a container:
```
docker run <container tag>
```


### Building
#### JAR
Using Maven, simply execute:
```
mvn package
```

#### Container
Build a JAR, then build a container using the 
```
docker build -t <container tag> -f quiz.Dockerfile .
```

### Testing
Tests are executed using simple JAR version, so MongoDB configuration is used from `application-local.properties` file.
To execute tests use Maven:
```
mvn test
```

### How to import data into MongoDB
The data is stored in `src/main/resources/movies`.
You can load the data by:
```
mongorestore -d movies src/main/resources/movies # or any other path to the "movies" directory
```
Don't forget to specify port if you are not using the default 27017 port.
