# Spring Kafka Order Service

A small event-driven order service built with Spring Boot and Apache Kafka.

It shows the pattern I use for backend microservices: a clean REST API in front,
business logic in a service layer, and order events published to Kafka for
downstream consumers (inventory, payments, notifications).

## Features
- Create and fetch orders via REST (`POST /api/orders`, `GET /api/orders/{id}`)
- Publishes `order-created` events to Kafka when an order is placed
- Kafka consumer that logs / processes order events asynchronously
- In-memory repository for the starter version (Cassandra / JPA planned - see Roadmap)
- Docker Compose for local Kafka

## Tech
Java 17, Spring Boot 3, Spring Kafka, Maven, Docker

## Run locally
```bash
docker compose up -d   # starts Kafka
mvn spring-boot:run
curl -X POST localhost:8080/api/orders -H 'Content-Type: application/json' \
  -d '{"customerId":"c-100","productId":"p-200","quantity":2,"amount":49.99}'
```

## Roadmap
- [ ] Persist orders in Cassandra
- [ ] Add order status lifecycle (CREATED -> PAID -> SHIPPED)
- [ ] Unit + integration tests with Testcontainers
- [ ] Metrics with Micrometer / Prometheus
