package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    @Override
    public Car findById(int carId) {
        // Implementation logic to retrieve the car from the persistence layer
        // Replace this with actual implementation

        // For demonstration purposes, let's assume we have a list of cars stored in memory
        // and we retrieve the car based on the given carId
        // You should replace this with your own logic to retrieve the car from your persistence layer

        List<Car> cars = getAllCars(); // Replace with your logic to fetch cars from the persistence layer

        for (Car car : cars) {
            if (car.getId() == carId) {
                return car;
            }
        }

        return null; // If car is not found, return null or throw an exception as per your requirement
    }

    // Dummy method to simulate fetching all cars from the persistence layer
    private List<Car> getAllCars() {
        // Replace this with actual logic to fetch cars from the persistence layer
        // For demonstration purposes, let's assume we have a list of cars stored in memory
        // Replace this with own logic to fetch cars from your persistence layer

        List<Car> cars = new ArrayList<>();

        cars.add(new Car(1, "Toyota", "Camry", 2022));
        cars.add(new Car(2, "Honda", "Civic", 2021));
        cars.add(new Car(3, "Ford", "Mustang", 2023));

        return cars;
    }
}