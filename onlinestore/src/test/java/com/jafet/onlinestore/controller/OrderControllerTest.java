package com.jafet.onlinestore.controller;

import com.jafet.onlinestore.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("dev")
@WebMvcTest(OrderController.class) // 1. Tells Spring Boot to only test the OrderController
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc; // 2. A tool for pretending to send HTTP requests

    @MockBean
    private OrderRepository orderRepository; // 3. A fake version of your repository

    @Test
    void whenGetAllOrders_thenReturns200() throws Exception {
        // 4. Perform a fake GET request to "/api/orders"
        mockMvc.perform(get("/api/orders"))
               .andExpect(status().isOk()); // 5. Expect the status to be 200 OK
    }
}