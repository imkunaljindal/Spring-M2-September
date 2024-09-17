package com.example.ProKart.dto.request;

import com.example.ProKart.model.Enum.Category;
import jakarta.annotation.security.DenyAll;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {

    String productName;

    int price;

    Category category;

    int quantity;
}
