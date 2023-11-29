package com.example.demo.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Jamshid Allahgholi","123"),
                new Customer(2L, "Leile Rafiei","123"),
                new Customer(3L, "Mohammadreza Allahgholi","123"),
                new Customer(4L, "Ali Allahgholi","123")
        );
    }

}
