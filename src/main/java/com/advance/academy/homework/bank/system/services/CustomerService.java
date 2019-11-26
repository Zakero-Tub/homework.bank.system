package com.advance.academy.homework.bank.system.services;

import com.advance.academy.homework.bank.system.model.Customer;
import com.advance.academy.homework.bank.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Integer customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()){
            throw new RuntimeException("Customer not fount");
        }
        return customer.get();
    }
}
