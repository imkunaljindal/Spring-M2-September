package com.example.ProKart.dto.request;

import com.example.ProKart.model.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    String name;

    int age;

    String email;

    Gender gender;
}
