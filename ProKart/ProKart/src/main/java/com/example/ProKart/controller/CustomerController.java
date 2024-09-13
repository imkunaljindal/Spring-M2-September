package com.example.ProKart.controller;

import com.example.ProKart.dto.request.CustomerRequest;
import com.example.ProKart.dto.response.CustomerResponse;
import com.example.ProKart.model.Customer;
import com.example.ProKart.model.Enum.Gender;
import com.example.ProKart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/age/{age}")
    public List<CustomerResponse> findByAge(@PathVariable("age") int age) {
        return customerService.findByAge(age);
    }

    // get people of a particular gender and age greater than. ex - all MALES with age >= 35
    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> findByGenderAndAgeGreaterThan(@PathVariable Gender gender,
                                                                @PathVariable int age) {
        return customerService.findByGenderAndAgeGreaterThan(gender,age);
    }
}
