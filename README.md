# Order Notification System

An event-driven microservices application built with Spring Boot, Apache Kafka, PostgreSQL, and Docker.

## Architecture

Client (Postman)
       ↓
Order Service (:8080)
       ↓
PostgreSQL (saves order)
       ↓
Kafka Topic: order-events
       ↓
Notification Service (:8081)
       ↓
Notification received: Order placed...

## Tech Stack

| Technology | Purpose |
|---|---|
| Spring Boot 4.x | Microservices framework |
| Apache Kafka | Async event streaming |
| PostgreSQL | Order persistence |
| Docker + Docker Compose | Containerization |
| Spring Data JPA | Database ORM |
| Lombok | Boilerplate reduction |

## Services

### order-service (port 8080)
- Accepts orders via REST API
- Saves order to PostgreSQL
- Publishes order event to Kafka

### notification-service (port 8081)
- Consumes order events from Kafka
- Logs notification for each order

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /orders | Place a new order |
| GET | /orders | Get all orders |

### Sample Request

POST /orders
Content-Type: application/json

{
    "product": "iPhone 15",
    "quantity": 2,
    "price": 999.99
}

### Sample Response

{
    "orderId": "26e22752-d99f-4be1-9c8f-bcae10d73998",
    "product": "iPhone 15",
    "quantity": 2,
    "price": 999.99
}

## How to Run

**Prerequisites:** Docker Desktop

**Steps:**

1. Clone the repo
   git clone git@github.com:rachit307/order-notification-system.git

2. Navigate to project
   cd order-notification-system

3. Start all services
   docker compose up --build

All 5 containers start automatically:
- Zookeeper
- Kafka
- PostgreSQL
- order-service
- notification-service

## Project Structure

order-notification-system/
├── order-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── notification-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
└── docker-compose.yml
