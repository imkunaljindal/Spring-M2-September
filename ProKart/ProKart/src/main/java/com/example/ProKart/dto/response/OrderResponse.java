package com.example.ProKart.dto.response;

import com.example.ProKart.model.Enum.OrderStatus;
import com.example.ProKart.model.Product;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    String orderNo;  // UUID

    double totalValue;

    OrderStatus orderStatus;

    Date orderedAt;

    CustomerResponse customer;

    List<ProductResponse> products;

}
