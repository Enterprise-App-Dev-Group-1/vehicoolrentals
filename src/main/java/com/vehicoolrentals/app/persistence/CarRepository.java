package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.domain.Car;

/**
 * The CarRepository interface defines the methods for accessing car data in the persistence layer.
 */
public interface CarRepository {
    /**
     * Finds a car by its ID.
     *
     * @param carId the ID of the car to find
     * @return the car with the specified ID, or null if not found
     */
    Car findById(int carId);
}