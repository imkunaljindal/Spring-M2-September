package com.example.ProKart.service;

import com.example.ProKart.Vehicle;
import com.example.ProKart.dto.request.SellerRequest;
import com.example.ProKart.dto.response.SellerResponse;
import com.example.ProKart.model.Seller;
import com.example.ProKart.repo.SellerRepository;
import com.example.ProKart.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    Vehicle vehicle;

    public SellerResponse addSeller(SellerRequest sellerRequest) {
        vehicle.speedUp();
        Seller seller = SellerTransformer.sellerRequestToSeller(sellerRequest);
        Seller savedSeller = sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponse(savedSeller);
    }
}
