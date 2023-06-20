package com.vehicoolrentals.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.vehicoolrentals.app")
public class VehicoolRentalsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehicoolRentalsApplication.class, args);
	}

}
