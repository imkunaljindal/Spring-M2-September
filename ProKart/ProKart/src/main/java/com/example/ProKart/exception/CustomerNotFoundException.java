package com.example.ProKart.exception;

import com.example.ProKart.repo.CustomerRepository;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
