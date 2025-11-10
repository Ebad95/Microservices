# Microservices 
## Microservices communication
This repo aims at providing information how microservices communicate with each other. We are going to use open feign client which will help us in communication.
There are two microservices created for the demo
1. Order Service 
2. Product Service

Created one feign client Product client that will interact with product service API
Order service is running on port 8081
Product Service is running on port 8082

Using Order Service we will communicate with product service using feign Client
