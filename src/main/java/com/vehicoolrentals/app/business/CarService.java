package com.vehicoolrentals.app.business;

import com.vehicoolrentals.app.domain.Car;

import java.time.LocalDate;

public interface CarService {
    boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate);

    void makeReservation(int carId, int customerId, LocalDate startDate, LocalDate endDate);
}