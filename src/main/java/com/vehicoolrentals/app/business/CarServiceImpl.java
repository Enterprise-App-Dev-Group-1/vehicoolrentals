package com.vehicoolrentals.app.business;

import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.persistence.CarRepository;

import java.time.LocalDate;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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

    @Override
    public void makeReservation(int carId, int customerId, LocalDate startDate, LocalDate endDate) {
        Car car = carRepository.findById(carId);
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }
    }
}