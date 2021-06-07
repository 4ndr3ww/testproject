# NCoding Test Project

## Tecnologies
- Java 11 +
- Spring Boot 
- PostgreSQL
- JPA



## Installation

- clone repository
[repository](https://github.com/4ndr3ww/testproject.git)


- create a database named like application.properties with the database configuration (user and password)
    spring.datasource.url=jdbc:postgresql://localhost:5432/ncodingdb // ncodingdb is the database created
- go to backend project and type
    ./mvnw spring-boot:run  //download dependecies and run application

        Windows example:
            mvnw.cmd spring-boot:run
        Unix based:
            mvwn spring-boot:run 

- go to any browser and type
    [Swagger] (http://localhost:8080/api/swagger-ui.html#/)
- Import ncondingtest.postman_collection.json file in your postman app to test end points