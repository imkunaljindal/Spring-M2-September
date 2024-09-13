package com.example.ProKart.controller;

import com.example.ProKart.dto.request.CustomerRequest;
import com.example.ProKart.dto.response.CustomerResponse;
import com.example.ProKart.model.Customer;
import com.example.ProKart.model.Enum.Gender;
import com.example.ProKart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {
        try {
            CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
            return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Duplicate email", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/age/{age}")
    public ResponseEntity findByAge(@PathVariable("age") int age) {
        List<CustomerResponse> customerResponses = customerService.findByAge(age);
        return new ResponseEntity<>(customerResponses,HttpStatus.ACCEPTED);
    }

    // get people of a particular gender and age greater than. ex - all MALES with age >= 35
    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> findByGenderAndAgeGreaterThan(@PathVariable Gender gender,
                                                                @PathVariable int age) {
        return customerService.findByGenderAndAgeGreaterThan(gender,age);
    }
}
