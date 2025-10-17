# C5.Springboot

# Online Store - Order Management API

This is a Spring Boot project for Challenge 5 of my backend bootcamp. It provides a simple REST API for creating, reading, and deleting orders.

## Prerequisites

- Java 17
- Maven

## How to Run the Application

1.  Clone the repository to your local machine.
2.  Navigate into the project directory: `cd onlinestone`
3.  Make the startup script executable (only needs to be done once): `chmod +x start.sh`
4.  Run the script: `./start.sh`
5.  The API will be running at `http://localhost:8080`.

## API Endpoints

- `POST /api/orders`: Create a new order.
- `GET /api/orders`: Get a list of all orders.
- `GET /api/orders/{id}`: Get a single order by its ID.
- `DELETE /api/orders/{id}`: Delete an order by its ID.

A Postman collection is included in the repository to test these endpoints.