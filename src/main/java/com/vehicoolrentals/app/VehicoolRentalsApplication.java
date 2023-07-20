package com.vehicoolrentals.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The VehicoolRentalsApplication class is the entry point for the Vehicool Rentals application.
 */
@SpringBootApplication(scanBasePackages = "com.vehicoolrentals.app")
@ComponentScan(basePackages = { "com.vehicoolrentals.app", "other.package.with.carapiclient" })
public class VehicoolRentalsApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehicoolRentalsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
