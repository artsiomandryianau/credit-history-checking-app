Microservice credit history cheking app
=======================================


This is a bank application capable to check credit history of client or
get a list of overdue loans.

This project is built in microservice arcgitekture. The services are implemented
in Java using Spring boot and Spring Cloud.

It uses four microservices:
- API Gateway - single entry point for all users.
- Data collection service - responsible for collection and connection data from different sources
(like client-data-service or loan-data-service).
- Loan data service - responsible for accessing data from non-relational database (MongoDB).
- Client data service - responsible for accessing data from relational databse (MySQL).

<p align="center">
  <a href ="##"><img alt="spring_vue" src="https://github.com/artsiomandryianau/credit-history-checking-app/tree/master/images/scheme.png"></a></p>
<p align="center">
  <a href ="##"><img alt="spring_vue" src="https://github.com/artsiomandryianau/SpringBoot-vue/blob/master/images/newlogo.jpg?raw=true"></a></p>

Technologies
------------

- Eureka for Lookup
- 



The microservices have an Java main application in src/test/java to run them stand alone. microservice-demo-order uses a stub for the other services then. Also there are tests that use customer driven contracts. That is why it is ensured that the services provide the correct interface. These CDC tests are used in microservice-demo-order to verify the stubs. In microserivce-demo-customer and microserivce-demo-catalog they are used to verify the implemented REST services.

