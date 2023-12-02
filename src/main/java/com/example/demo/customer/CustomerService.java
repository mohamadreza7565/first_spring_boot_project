package com.example.demo.customer;

import com.example.demo.BaseSuccessResponse;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepo.getCustomers();
    }

    BaseSuccessResponse<Customer> getCustomer(Long id) {

        Customer c = getCustomers().stream().filter(
                customer -> Objects.equals(customer.getCustomerId(), id)
        ).findFirst().orElseThrow(
                ()-> new NotFoundException(
                        "customer with id " + id + " not found",
                        null
                )
        );

        return new BaseSuccessResponse<>("",c);
    }

}
