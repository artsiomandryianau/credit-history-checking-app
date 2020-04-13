#Client data service
###Microservice responsible for accessing to MySQL client database and getting client's information by client id.

Technology list:
*Java 8+
*Spring Boot
*Spring Cloud
*MySQL
*Lombok


Endpoint:
    GET /client/{clientId}
    Parametr:
        *clientId - unique id of each bank client
