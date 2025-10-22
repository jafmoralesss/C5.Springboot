package com.jafet.onlinestore.controller;

import com.jafet.onlinestore.entity.Order;
import com.jafet.onlinestore.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 1. Starts the WHOLE app
@ActiveProfiles("dev")
class OrderControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate; // 2. A real HTTP client for testing

    @Autowired
    private OrderRepository orderRepository; // 3. The REAL repository to check the database

    @Test
    void whenPostOrder_thenCreateOrder() {
        // Arrange: Create a new order object
        Order order = new Order();
        order.setProductName("Integration Test Product");
        order.setQuantity(5);
        order.setPrice(10.0);

        // Act: Send a real POST request to the API
        ResponseEntity<Order> response = restTemplate.postForEntity("/api/orders", order, Order.class);

        // Assert: Check the results
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
        assertThat(response.getBody().getProductName()).isEqualTo("Integration Test Product");

        // Assert: Check the database directly
        Order foundInDb = orderRepository.findById(response.getBody().getId()).orElse(null);
        assertThat(foundInDb).isNotNull();
        assertThat(foundInDb.getProductName()).isEqualTo("Integration Test Product");
    }
}