package com.example.ProKart.model;

import com.example.ProKart.model.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderNo;  // UUID

    double totalValue;

    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
}
