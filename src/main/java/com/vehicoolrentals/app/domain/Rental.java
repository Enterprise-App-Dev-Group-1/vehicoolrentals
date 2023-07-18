package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

/**
 * The Rental class represents a rental entity that implements the IRental interface.
 */
public class Rental implements IRental {
    public ArrayList<Car> Cars;
    public float RentalPrice;

    /**
     * Retrieves the price of the rental.
     *
     * @return the price of the rental
     */
    @Override
    public float getRentalPrice() {
        return RentalPrice;
    }

    /**
     * Sets the price of the rental.
     *
     * @param rentalPrice the price of the rental to set
     */
    @Override
    public void setRentalPrice(float rentalPrice) {
        RentalPrice = rentalPrice;
    }

    /**
     * Retrieves the cars associated with the rental.
     *
     * @return the list of cars belonging to the rental
     */
    @Override
    public ArrayList<Car> getCars() {
        return Cars;
    }

    /**
     * Sets the cars associated with the rental.
     *
     * @param cars the list of cars to set for the rental
     */
    @Override
    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }
}
