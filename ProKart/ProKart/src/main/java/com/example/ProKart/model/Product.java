package com.example.ProKart.model;

import com.example.ProKart.model.Enum.Category;
import com.example.ProKart.model.Enum.ProductStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.query.Order;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    int price;

    @Enumerated(EnumType.STRING)
    Category category;

    int quantity;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Seller seller;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="product_orders",
    joinColumns = @JoinColumn(name="product_id"),
    inverseJoinColumns = @JoinColumn(name="order_entity_id"))
    List<OrderEntity> orders = new ArrayList<>();
}
