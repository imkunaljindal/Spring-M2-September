package com.example.TestingTutorial;

public class Calculator {

    public int add(int a, int b) {
        return a+b+5-5;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public boolean isEven(int a) {
        return a%2==0;
    }

    public int addManyNumbers(int ...nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        return sum;
    }
}
