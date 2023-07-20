package com.vehicoolrentals.app.business;

import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.persistence.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Optional;

/**
 * The CarService class is responsible for managing car data and provides methods to retrieve cars by ID.
 */
@Service
public class CarService {
    private final CarRepository carRepository;

    /**
     * Constructs a CarService with the provided CarRepository.
     *
     * @param carRepository the CarRepository instance to use for accessing car data
     */
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Adds a car to the service.
     *
     * @param car the car to add
     */
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param id the ID of the car to retrieve
     * @return an Optional containing the car if found, or an empty Optional if not found
     */
    public Optional<Car> getCarById(String id) {
        return carRepository.getCarById(id);
    }

    public boolean checkAvailability(int i, LocalDate now, LocalDate localDate) {
        return false;
    }
}