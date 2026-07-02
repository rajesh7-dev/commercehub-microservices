# CommerceHub Microservices Platform

A distributed e-commerce backend platform built using Spring Boot Microservices architecture, demonstrating both synchronous and asynchronous inter-service communication patterns.

---

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Cloud Gateway
- Eureka Service Discovery
- OpenFeign
- Spring Security
- JWT Authentication
- Apache Kafka
- Spring Kafka
- MySQL
- Maven

---

## Architecture

### Core Services

- API Gateway (Single Entry Point)
- Discovery Server (Eureka Registry)
- Auth Service (JWT Authentication)
- Product Service
- Order Service
- Notification Service

---


## System Architecture

```text
                    +----------------+
                    |  API Gateway   |
                    +--------+-------+
                             |
         -----------------------------------------
         |                 |                     |
         ▼                 ▼                     ▼
+---------------+ +---------------+ +-------------------+
| Auth Service  | | Product Service| |  Order Service   |
+---------------+ +---------------+ +---------+---------+
                                              |
                                              | Feign Client
                                              ▼
                                    +-------------------+
                                    | Product Service   |
                                    +-------------------+

                                              |
                                              | Kafka Producer
                                              ▼

                                    +-------------------+
                                    |   Kafka Topic     |
                                    |   order-topic     |
                                    +---------+---------+
                                              |
                                              | Kafka Consumer
                                              ▼

                                    +-------------------+
                                    | Notification      |
                                    | Service           |
                                    +-------------------+
```

---

## Features

### Authentication & Security

- User Registration
- User Login
- JWT Token Generation
- Protected APIs using JWT Authentication
- API Gateway based request routing

### Product Management

- Create Product
- View Products
- Manage Inventory

### Order Management

- Place Orders
- Product Validation before Order Creation
- Stock Availability Validation

### Event-Driven Communication

- Order Service publishes Order Events to Kafka
- Notification Service consumes Order Events
- Email notification simulation through Kafka Consumers

---

## Inter-Service Communication

### Synchronous Communication (Feign)

Order Service communicates with Product Service using OpenFeign.

Responsibilities:

- Fetch Product Details
- Verify Product Availability
- Validate Stock Quantity

---

### Asynchronous Communication (Kafka)

Order Service publishes messages to Kafka Topic:

```text
order-topic
```

Notification Service listens to Kafka events and processes notifications independently.

Benefits:

- Loose Coupling
- Scalability
- Event-Driven Architecture
- Improved Fault Tolerance

---

## Kafka Workflow

```text
Order Created
      |
      ▼
Order Service
      |
      ▼
Kafka Producer
      |
      ▼
order-topic
      |
      ▼
Notification Service
      |
      ▼
Email Sent Successfully
```

---

## API Testing

### Register User

```http
POST /auth/register
```

### Login

```http
POST /auth/login
```

### Access Protected APIs

```http
Authorization: Bearer <JWT_TOKEN>
```

### Create Product

```http
POST /products
```

### Place Order

```http
POST /orders
```

---


## Services

```text
api-gateway/
auth-service/
discovery-server/
product-service/
order-service/
notification-service/
```

---

## Learning Outcomes
- Microservices architecture
- Service discovery using Eureka
- API Gateway Pattern
- JWT-based authentication
- OpenFeign Client Communication
- Event-Driven Architecture
- Apache Kafka Producer & Consumer
- Synchronous vs Asynchronous Communication
- Loose Coupling Between Services
- Distributed System Fundamentals

---

## Future Enhancements

- Global Exception Handling
- Inventory Reduction after Order Creation
- Circuit Breaker (Resilience4j)
- Distributed Tracing
- Docker Containerization
- Kubernetes Deployment
- Real Email Integration
- Dead Letter Queue (DLQ)
- Kafka Retry Mechanisms


