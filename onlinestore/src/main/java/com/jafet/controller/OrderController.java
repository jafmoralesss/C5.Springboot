package com.jafet.onlinestore.controller;

import com.jafet.onlinestore.entity.Order;
import com.jafet.onlinestore.repository.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Operation(summary = "Create a new order", description = "Creates a new order and saves it to the database.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Order created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input supplied"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @Operation(summary = "Retrieve a list of all orders")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of orders")
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Operation(summary = "Get a specific order by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the order"),
            @ApiResponse(responseCode = "404", description = "Order not found with the given ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an order by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Order deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found with the given ID")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Operation(summary = "Get the current environment's welcome message")
    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Value("${meli.api-key}")
    private String apiKey;

    @Operation(summary = "Get the current API Key", description = "Retrieves the API key from the configuration. This is for demonstration purposes.")
    @GetMapping("/api-key")
    public String getApiKey() {
        return "The current API Key is: " + apiKey;
    }
}