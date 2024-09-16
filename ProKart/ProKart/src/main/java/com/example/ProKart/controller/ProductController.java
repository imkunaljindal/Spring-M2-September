package com.example.ProKart.controller;

import com.example.ProKart.dto.request.ProductRequest;
import com.example.ProKart.dto.response.ProductResponse;
import com.example.ProKart.exception.SellerNotFoundException;
import com.example.ProKart.model.Seller;
import com.example.ProKart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest,
                       @RequestParam("seller-email") String sellerEmail) {

        try {
            return new ResponseEntity(productService.addProduct(productRequest,sellerEmail),HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
