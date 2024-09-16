package com.example.ProKart.exception;

import com.example.ProKart.model.Seller;

public class SellerNotFoundException extends RuntimeException {
    public SellerNotFoundException(String message) {
        super(message);
    }
}
