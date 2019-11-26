package com.advance.academy.homework.bank.system.controller;

import com.advance.academy.homework.bank.system.model.Customer;
import com.advance.academy.homework.bank.system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public void addCustomer(){

    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        return customerService.getCustomer(customerId);
    }
}
