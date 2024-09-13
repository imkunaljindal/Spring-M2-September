package com.example.ProKart.model;

import com.example.ProKart.model.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Email;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true, nullable = false)
    @Email
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

//    @Size(min = 10,max = 10)
//    String phoneNo;d

    @CreationTimestamp
    Date created;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();
}
