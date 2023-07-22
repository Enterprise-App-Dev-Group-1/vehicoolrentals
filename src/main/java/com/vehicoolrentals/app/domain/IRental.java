package com.vehicoolrentals.app.domain;

import java.util.ArrayList;
import java.util.Date;

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

    /**
     * Gets the end date associated with the rental.
     *
     * @return the end date of the rental
     */
    Date getRentalEnd();
    /**
     * Sets the end date associated with the rental.
     *
     * @param rentalEnd the date the rental of the car ends
     */
    void setRentalEnd(Date rentalEnd);
    /**
     * Gets the start date associated with the rental.
     *
     * @return the start date of the rental
     */
    Date getRentalStart();
    /**
     * Sets the start date associated with the rental.
     *
     * @param rentalStart the date the rental of the car starts
     */
    void setRentalStart(Date rentalStart);

}
