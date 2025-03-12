package org.example.Ex04.service;

import org.example.Ex04.model.Customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void testRegisterCustomer_ValidAge() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, true);
        assertTrue(customerService.registerCustomer(customer));
    }

    @Test
    void testRegisterCustomer_ValidAgeLimitMin() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 18, true);
        assertTrue(customerService.registerCustomer(customer));
    }

    @Test
    void testRegisterCustomer_ValidAgeLimitMax() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 99, true);
        assertTrue(customerService.registerCustomer(customer));
    }

    @Test
    void testRegisterCustomer_InvalidAgeMin() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 17, true);
        assertFalse(customerService.registerCustomer(customer));
    }

    @Test
    void testRegisterCustomer_InvalidAgeMax() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 100, true);
        assertFalse(customerService.registerCustomer(customer));
    }

    @Test
    void testUpdateCustomer_Active() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, true);
        assertTrue(customerService.updateCustomer(customer, "Pedro da Silva", "pedro@gmail.com", 20));
    }

    @Test
    void testUpdateCustomer_Inactive() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, false);
        assertFalse(customerService.updateCustomer(customer, "Pedro da Silva", "pedro@gmail.com", 20));
    }

    @Test
    void testDeleteCustomer_Active() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, true);
        assertTrue(customerService.deleteCustomer(customer));
    }

    @Test
    void testDeleteCustomer_Inactive() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, false);
        assertFalse(customerService.deleteCustomer(customer));
    }

    boolean isValidEmail(String email) {
        return email.matches("^[\\w-.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pedro@gmail.com", "pedrosilva@gmail.com", "pedro@hotmail.com"})
    void testValidEmail(String email) {
        assertTrue(isValidEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pedro.gmail.com", "pedrosilva@gmail", "pedro"})
    void testInvalidEmail(String email) {
        assertFalse(isValidEmail(email));
    }

    @Test
    void testRegisterCustomer_Success() {
        Customer customer = new Customer(1, "Pedro", "pedro@gmail.com", 20, true);
        assertTrue(customerService.registerCustomer(customer));
    }

}