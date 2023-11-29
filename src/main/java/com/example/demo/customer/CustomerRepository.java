package com.example.demo.customer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        // TODO Implement real db
        return Arrays.asList(
                new Customer(1L, "Jamshid Allahgholi","123"),
                new Customer(2L, "Leile Rafiei","123")
        );
    }
}
