package com.example.ProKart.model;

import com.example.ProKart.model.Enum.Category;
import com.example.ProKart.model.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    String price;

    @Enumerated(EnumType.STRING)
    Category category;

    int quantity;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;
}
