package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class CoviMApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoviMApplication.class, args);
	}

}
