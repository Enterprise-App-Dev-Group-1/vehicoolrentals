package com.vehicoolrentals.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The VehicoolRentalsApplication class is the entry point for the Vehicool Rentals application.
 */
@SpringBootApplication(scanBasePackages = "com.vehicoolrentals.app")
public class VehicoolRentalsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehicoolRentalsApplication.class, args);
	}

}
