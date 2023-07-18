package com.vehicoolrentals.app.business;

import com.vehicoolrentals.app.domain.Car;

import java.time.LocalDate;

/**
 * The CarService interface provides methods for checking car availability and making reservations.
 */
public interface CarService {
    /**
     * Checks the availability of a car for a specific time period.
     *
     * @param carId     the ID of the car to check availability for
     * @param startDate the start date of the time period
     * @param endDate   the end date of the time period
     * @return true if the car is available for the specified time period, false otherwise
     */
    boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate);

    /**
     * Makes a reservation for a car for a specific time period.
     *
     * @param carId      the ID of the car to make a reservation for
     * @param customerId the ID of the customer making the reservation
     * @param startDate  the start date of the reservation
     * @param endDate    the end date of the reservation
     */
    void makeReservation(int carId, int customerId, LocalDate startDate, LocalDate endDate);
}