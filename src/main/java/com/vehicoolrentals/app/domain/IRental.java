package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

/**
 * The IRental interface defines the properties and methods for a rental entity.
 */
public interface IRental {
    /**
     * Retrieves the price of the rental.
     *
     * @return the price of the rental
     */
    float getRentalPrice();

    /**
     * Sets the price of the rental.
     *
     * @param rentalPrice the price of the rental to set
     */
    void setRentalPrice(float rentalPrice);

    /**
     * Retrieves the cars associated with the rental.
     *
     * @return the list of cars belonging to the rental
     */
    ArrayList<Car> getCars();

    /**
     * Sets the cars associated with the rental.
     *
     * @param cars the list of cars to set for the rental
     */
    void setCars(ArrayList<Car> cars);
}
