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

To use feign client in application we need to add following dependency to application 

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
	<version>4.3.0</version>
</dependency>

And also give path of product service in application.properties 
feign.client.product-service.url=http://localhost:8082

@EnableFeignClients annotation also needs to be added.



## Service Discovery

We can see that we are hard coding the product service url in application so that is not a good practice there can be multiple instances of product service running so we need service discovery functionality which will help in getting a product service instance 
We will create a Eureka server that will register different services and will keep track of there port , ip addresses whether the service is up or down 
I have already created eureka server which is running on port 8761 this this is the repo https://github.com/Ebad95/EurekaServer 

For order service and product service to register to eureka server as client they need to add following dependency in pom

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
	<version>4.3.0</version>
</dependency>

Then in application.properties we need to add following properties 

eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true

By default feign client used service discovery for fetching instances but when using rest template we need to add discovery client to fetch the instances and also write our own load balancing logic to add client side load balancing which we will see in next topic 

