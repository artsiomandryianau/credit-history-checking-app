Microservice credit history cheking app (In progress)
=====================================================

(Microservice architecture)
---------------------------

DESCRIPTION
-----------
This is a bank application capable to create reports or statistics about clients and loans. Client info situated in relational MySQL database and loans info - at non-relational MongoDB. Client can comunicate only with API Gateway which is single entry point for all users. This project is built in microservice arcgitekture. The services are implemented in Java using Spring boot and Spring Cloud.
SCHEME
-------
<p align="center">
  <a href ="##"><img alt="spring_vue" src="https://github.com/artsiomandryianau/credit-history-checking-app/blob/master/images/scheme.png"></a></p>
  
It uses five microservices:
- API Gateway - single entry point for all users. Can talk to collection-data-service to get reports or to data-analize-service to get statistics based on this data.
- Data-collection-service - responsible for collection and connection data from different sources (like client-data-service or loan-data-service).
- Data-analize-service - responsible for creating statistics based on data from data-collection service.
- Loan-data-service - responsible for accessing data from non-relational database (MongoDB).
- Client-data-service - responsible for accessing data from relational databse (MySQL).

Technologies
------------
- Java 11
- Spring Boot
- Spring MVC
- MySQL
- MongoDB
- Hibernate, JDBC
- Spring Cloud

How to run
----------
*Clone everything
*Create a mongo db using mongo db creator
*Create MySQL using scripts
*...(in progress)
