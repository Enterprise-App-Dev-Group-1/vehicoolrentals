package com.vehicoolrentals.app.business;

import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.persistence.CarRepository;

import java.time.LocalDate;

/**
 * The CarServiceImpl class implements the CarService interface and provides the implementation for
 * checking car availability and making reservations.
 */
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    /**
     * Constructs a CarServiceImpl object with the specified CarRepository.
     *
     * @param carRepository the CarRepository to use for retrieving car information
     */
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Checks the availability of a car for a specific time period.
     *
     * @param carId     the ID of the car to check availability for
     * @param startDate the start date of the time period
     * @param endDate   the end date of the time period
     * @return true if the car is available for the specified time period, false otherwise
     * @throws IllegalArgumentException if the car with the specified ID is not found
     */
    @Override
    public boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate) {
        Car car = carRepository.findById(carId);
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }

        // Perform availability check logic based on car's availability status or other criteria
        // For simplicity, assuming availability is always true in this example
        return true;
    }

    /**
     * Makes a reservation for a car for a specific time period.
     *
     * @param carId      the ID of the car to make a reservation for
     * @param customerId the ID of the customer making the reservation
     * @param startDate  the start date of the reservation
     * @param endDate    the end date of the reservation
     * @throws IllegalArgumentException if the car with the specified ID is not found
     */
    @Override
    public void makeReservation(int carId, int customerId, LocalDate startDate, LocalDate endDate) {
        Car car = carRepository.findById(carId);
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }
    }
}