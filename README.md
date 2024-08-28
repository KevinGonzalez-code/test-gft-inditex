# INDITEX PRICE SERVICE

##

This project it is a functioning Spring Boot service.  
It is based on version 3.3.3 of Spring Boot and 17 of Java.

### General service configuration:

The specific variables of the microservice are the following:

ini
PORT_NUMBER=8080

-   Run with spring-boot

To run the application
mvn spring-boot:run -Dspring-boot.run.profiles=local

## Configuration to start the service from docker

Build the Docker image:

```
docker build -t inditex-price-service .
```

Execute the container:

```
docker run -p 8080:8080 inditex-price-service
```

This will expose the application at http://localhost:8080, and the application will be ready to receive applications.

To build and run the application using Docker:

```
docker build -t inditex-price-service .
docker run -p 8080:8080 inditex-price-service
```

## Swagger UI

The API documentation is available at: http://localhost:8080/swagger-ui.html.
