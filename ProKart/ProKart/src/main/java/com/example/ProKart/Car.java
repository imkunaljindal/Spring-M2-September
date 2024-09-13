package com.example.ProKart;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
    @Override
    public void speedUp() {
        System.out.println("Car speeded up");
    }
}
