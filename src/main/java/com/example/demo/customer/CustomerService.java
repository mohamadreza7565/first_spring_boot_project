package com.example.demo.customer;

import com.example.demo.BaseSuccessResponse;
import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER =
             LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getCustomers() {
        LOGGER.error("getCustomer was called");
        return customerRepository.findAll();
    }


    BaseSuccessResponse<Customer> getCustomer(Long id) {

        Customer c = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "customer with id " + id + " not found",
                        null
                )
        );

        return new BaseSuccessResponse<>("", c);
    }

}
