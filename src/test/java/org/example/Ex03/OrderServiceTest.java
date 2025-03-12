package org.example.Ex03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private PaymentProcessor paymentProcessor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void processOrder_Pedido_Confirmado() {
        when(paymentProcessor.processPayment(10.0)).thenReturn(true);
        boolean result = orderService.processOrder(10.0);
        assertTrue(result);
        verify(paymentProcessor).processPayment(10.0);
    }

    @Test
    void processOrder_Pedido_Recusado() {
        when(paymentProcessor.processPayment(20.0)).thenReturn(false);
        boolean result = orderService.processOrder(20.0);
        assertFalse(result);
        verify(paymentProcessor).processPayment(20.0);
    }
}