package com.vehicoolrentals.app.business;

import java.time.LocalDate;

public interface RentalServiceImpl {
    boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate);

    void makeReservation(int carId, int customerId, LocalDate startDate, LocalDate endDate);
}
