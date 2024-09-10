package com.example.TestingTutorial;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingTutorialApplication.class, args);
		Calculator c = new Calculator();

//		System.out.println(c.addManyNumbers(4,5));
//		System.out.println(c.addManyNumbers(5,6,7,1,7,8));
	}

}
