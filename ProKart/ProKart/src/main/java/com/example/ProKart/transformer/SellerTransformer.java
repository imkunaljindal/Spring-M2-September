package com.example.ProKart.transformer;

import com.example.ProKart.dto.request.SellerRequest;
import com.example.ProKart.dto.response.SellerResponse;
import com.example.ProKart.model.Seller;

public class SellerTransformer {

    public static Seller sellerRequestToSeller(SellerRequest sellerRequest) {
        return Seller.builder()
                .name(sellerRequest.getName())
                .email(sellerRequest.getEmail())
                .pan(sellerRequest.getPan())
                .build();
    }

    public static SellerResponse sellerToSellerResponse(Seller seller) {
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .pan(seller.getPan())
                .build();
    }
}
