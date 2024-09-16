package com.example.ProKart.service;

import com.example.ProKart.dto.request.ProductRequest;
import com.example.ProKart.dto.response.ProductResponse;
import com.example.ProKart.exception.SellerNotFoundException;
import com.example.ProKart.model.Product;
import com.example.ProKart.model.Seller;
import com.example.ProKart.repo.SellerRepository;
import com.example.ProKart.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(ProductRequest productRequest,
                                      String sellerEmail) {

        Optional<Seller> sellerOptional = sellerRepository.findByEmail(sellerEmail);
        if(sellerOptional.isEmpty()) {
            throw new SellerNotFoundException("Invalid seller email");
        }

        Seller seller = sellerOptional.get();

        Product product = ProductTransformer.productRequestToProduct(productRequest);
        product.setSeller(seller);

        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both seller and product
        int size = seller.getProducts().size();
        Product savedProduct = savedSeller.getProducts().get(size - 1);

        return ProductTransformer.productToProductResponse(savedProduct);
    }
}
