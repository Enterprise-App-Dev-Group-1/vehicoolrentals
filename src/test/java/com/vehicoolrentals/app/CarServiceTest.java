package com.vehicoolrentals.app;

import com.vehicoolrentals.app.business.CarService;
import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.persistence.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarServiceTest {

	private CarService carService;
	private CarRepository carRepository;

	@BeforeEach
	public void setup() {
		// Create a test implementation of CarRepository
		carRepository = new TestCarRepository();

		// Initialize the CarService with the test CarRepository
		carService = new CarService(carRepository);
	}

	private static class TestCarRepository extends CarRepository {

		private final Map<Integer, Car> cars = new HashMap<>();

		public TestCarRepository() {
			// For testing purposes, let's assume car with ID 1 is always available
			cars.put(1, new Car(1, "Test Make", "Test Model", 100));
			// Add more test cars as needed for the test
			cars.put(2, new Car(2, "Another Make", "Another Model", 120));
		}

		@Override
		public Car findById(int carId) {
			return cars.get(carId);
		}

		@Override
		public boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate) {
			Car car = cars.get(carId);
			return car != null;
		}
	}

	@Test
	public void testCarServiceInterface() {
		// Test for car with ID 1
		boolean availability1 = carService.checkAvailability(1, LocalDate.now(), LocalDate.now().plusDays(1));
		assertFalse(availability1, "Car with ID 1 should be available for the specified dates.");

		// Test for car with ID 2
		boolean availability2 = carService.checkAvailability(2, LocalDate.now(), LocalDate.now().plusDays(1));
		assertFalse(availability2, "Car with ID 2 should be available for the specified dates.");
	}
}