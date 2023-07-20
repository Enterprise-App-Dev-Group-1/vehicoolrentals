package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.domain.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The CarRepository class is responsible for managing car data and provides methods to retrieve cars by ID.
 */
@Repository
public abstract class CarRepository {
    private final List<Car> cars;

    /**
     * Constructs a CarRepository with an empty list of cars.
     */
    public CarRepository() {
        cars = new ArrayList<>();
    }

    /**
     * Adds a car to the repository.
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

    public abstract Car findById(int carId);

    public abstract boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate);
}
// Compare this snippet from src\main\java\com\vehicoolrentals\app\persistence\CarRepository.java: