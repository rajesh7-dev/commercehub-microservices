# CommerceHub Microservices Platform

A distributed e-commerce backend system built using Spring Boot Microservices architecture.

## Technologies Used
- Java 17
- Spring Boot
- Spring Cloud Gateway
- Eureka Service Discovery
- OpenFeign
- JWT Authentication
- Maven

## Architecture
- API Gateway (Single Entry Point)
- Discovery Server (Service Registry)
- Auth Service (JWT Authentication)
- Product Service
- Order Service

## Features
- User Registration & Login
- JWT Token Generation
- Secure API endpoints via API Gateway
- Service-to-Service communication

## API Testing
- Register: POST /auth/register
- Login: POST /auth/login
- Access protected API using Header:

```
  Authorization: Bearer <token>
```
## Project Structure

api-gateway/
auth-service/
product-service/
order-service/
discovery-server/

## Learning Outcomes
- Microservices architecture
- Service discovery using Eureka
- API Gateway routing
- JWT-based authentication

