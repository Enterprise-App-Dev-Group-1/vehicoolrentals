package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

public class Rental implements IRental {
    public ArrayList<Car> Cars;
    public float RentalPrice;


    @Override
    public float getRentalPrice() {
        return RentalPrice;
    }

    @Override
    public void setRentalPrice(float rentalPrice) {
        RentalPrice = rentalPrice;
    }

    @Override
    public ArrayList<Car> getCars() {
        return Cars;
    }

    @Override
    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }
}
