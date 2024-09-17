package com.example.ProKart.exception;

public class ProductNotAvailableException extends RuntimeException{

    public ProductNotAvailableException(String message) {
        super(message);
    }
}
