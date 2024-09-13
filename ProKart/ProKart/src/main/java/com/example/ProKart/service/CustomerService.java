package com.example.ProKart.service;

import com.example.ProKart.dto.request.CustomerRequest;
import com.example.ProKart.dto.response.CustomerResponse;
import com.example.ProKart.model.Customer;
import com.example.ProKart.model.Enum.Gender;
import com.example.ProKart.repo.CustomerRepository;
import com.example.ProKart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> findByAge(int age) {
        List<Customer> customers = customerRepository.findByAge(age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }

    public List<CustomerResponse> findByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers = customerRepository.getCustomersByGenderAndAgeGreaterThan(gender,age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }

        return customerResponses;
    }
}
