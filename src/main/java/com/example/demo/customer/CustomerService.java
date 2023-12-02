package com.example.demo.customer;

import com.example.demo.BaseSuccessResponse;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    BaseSuccessResponse<Customer> getCustomer(Long id) {

        Customer c = customerRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(
                        "customer with id " + id + " not found",
                        null
                )
        );

        return new BaseSuccessResponse<>("",c);
    }

}
