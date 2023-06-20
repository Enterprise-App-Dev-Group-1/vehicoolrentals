package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

public interface IRental {
    float getRentalPrice();

    void setRentalPrice(float rentalPrice);

    ArrayList<Car> getCars();

    void setCars(ArrayList<Car> cars);
}
