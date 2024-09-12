package com.example.ProKart.service;

import com.example.ProKart.dto.request.CustomerRequest;
import com.example.ProKart.dto.response.CustomerResponse;
import com.example.ProKart.model.Customer;
import com.example.ProKart.repo.CustomerRepository;
import com.example.ProKart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
}
