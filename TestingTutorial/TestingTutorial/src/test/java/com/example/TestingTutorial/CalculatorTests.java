package com.example.TestingTutorial;

import org.junit.jupiter.api.*;

public class CalculatorTests {

    Calculator c = new Calculator();

    @BeforeEach
    public void beforeTest() {
        System.out.println("This is executed before every test");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("This is executed after every test case");
    }

    @BeforeAll
    public static void setup() {
        System.out.println("This is executed before all the tests");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("This is executed after all the test cases");
    }

    @Test
    public void testAdd() {
        System.out.println("Test 1");
        int actual = c.add(10,15);
        int expected = 25;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testIsEven() {
        System.out.println("Test 2");
        boolean actual = c.isEven(26);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSubtract() {
        System.out.println("Test 3");
        int actual = c.subtract(5,3);
        int expected = 2;
        Assertions.assertEquals(expected,actual);
    }
}
