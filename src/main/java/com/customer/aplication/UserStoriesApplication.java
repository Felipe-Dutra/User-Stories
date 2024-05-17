package com.customer.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.customer.controller"})
public class UserStoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserStoriesApplication.class, args);
	}

}
