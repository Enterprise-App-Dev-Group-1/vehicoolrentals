package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.domain.Car;

public interface CarRepository {
    Car findById(int carId);
}