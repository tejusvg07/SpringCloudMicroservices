# SpringCloudMicroservices
Spring cloud microservices programs:

spring-boot-eureka-server is a eureka server program to which all the microservices register.
eureka-client-server is a microservice programs which has a helloResource method, which return a message at a REST endpoint.
eureka-client is a microservice program which has a method to receive the message from eureka-client-server.
zuul-server is a micro-proxy program which exposes all the REST endpoints registered with spring-boot-eureka-server.
