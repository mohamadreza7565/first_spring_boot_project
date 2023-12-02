package com.example.demo.customer;


import com.example.demo.BaseSuccessResponse;
import com.example.demo.exception.ApiRequestException;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequestMapping(path = "api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "get/exception", params = {"customerId"})
    Customer getCustomerException(@PathParam("customerId") Long customerId) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + customerId, null
        );
    }

    @GetMapping(value = "get", params = {"customerId"})
    BaseSuccessResponse<Customer> getCustomer(@PathParam("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    BaseSuccessResponse<Customer> createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST Request ...");
        System.out.println(customer.getPassword());
        System.out.println(customer);
        return new BaseSuccessResponse<>("",customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("PUT Request ...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    Long deleteNewCustomer(@PathVariable("customerId") Long customerId) {
        System.out.println("DELETE Request ...");
        System.out.println(customerId);
        return customerId;
    }


}
