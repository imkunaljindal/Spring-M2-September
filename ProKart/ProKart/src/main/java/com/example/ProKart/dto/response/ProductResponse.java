package com.example.ProKart.dto.response;

import com.example.ProKart.model.Enum.Category;
import com.example.ProKart.model.Enum.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    String productName;

    String price;

    Category category;

    int quantity;

    ProductStatus productStatus;

    SellerResponse seller;
}
