package com.vehicoolrentals.app.service;

import com.vehicoolrentals.app.domain.Car;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The CarService class is responsible for managing car data and provides methods to retrieve cars by ID.
 */
@Service
public class CarService {
    private List<Car> cars;

    /**
     * Constructs a CarService with an empty list of cars.
     */
    public CarService() {
        cars = new ArrayList<>();
    }

    /**
     * Adds a car to the service.
     *
     * @param car the car to add
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param id the ID of the car to retrieve
     * @return an Optional containing the car if found, or an empty Optional if not found
     */
    public Optional<Car> getCarById(String id) {
        try {
            return cars.stream()
                    .filter(car -> {
                        try {
                            return car.getId().equals(id);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    })
                    .findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public boolean checkAvailability(int i, LocalDate now, LocalDate localDate) {
        return false;
    }
}