package com.example.ProKart.transformer;

import com.example.ProKart.dto.request.CustomerRequest;
import com.example.ProKart.dto.response.CustomerResponse;
import com.example.ProKart.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}
