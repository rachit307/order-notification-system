\# Order Notification System



An event-driven microservices application built with Spring Boot, Apache Kafka, PostgreSQL, and Docker.



\## Architecture



Client (Postman)

&#x20;      ↓

Order Service (:8080)

&#x20;      ↓

PostgreSQL (saves order)

&#x20;      ↓

Kafka Topic: order-events

&#x20;      ↓

Notification Service (:8081)

&#x20;      ↓

"Notification received: Order placed..."



\## Tech Stack



| Technology | Purpose |

|---|---|

| Spring Boot 4.x | Microservices framework |

| Apache Kafka | Async event streaming |

| PostgreSQL | Order persistence |

| Docker + Docker Compose | Containerization |

| Spring Data JPA | Database ORM |

| Lombok | Boilerplate reduction |



\## Services



\### order-service (port 8080)

\- Accepts orders via REST API

\- Saves order to PostgreSQL

\- Publishes order event to Kafka



\### notification-service (port 8081)

\- Consumes order events from Kafka

\- Logs notification for each order



\## API Endpoints



| Method | Endpoint | Description |

|---|---|---|

| POST | /orders | Place a new order |

| GET | /orders | Get all orders |



\### Sample Request

POST /orders

{

&#x20;   "product": "iPhone 15",

&#x20;   "quantity": 2,

&#x20;   "price": 999.99

}



\### Sample Response

{

&#x20;   "orderId": "26e22752-d99f-4be1-9c8f-bcae10d73998",

&#x20;   "product": "iPhone 15",

&#x20;   "quantity": 2,

&#x20;   "price": 999.99

}



\## How to Run



Prerequisites: Docker Desktop



Steps:

git clone git@github.com:rachit307/order-notification-system.git

cd order-notification-system

docker compose up --build



All 5 containers start automatically:

\- Zookeeper

\- Kafka

\- PostgreSQL

\- order-service

\- notification-service



\## Project Structure



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

