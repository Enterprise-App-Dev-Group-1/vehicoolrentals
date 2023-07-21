package com.vehicoolrentals.app.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Rental class represents a rental entity that implements the IRental interface.
 */
public class Rental implements IRental {
    public ArrayList<Car> Cars;
    public float RentalPrice;
    public Date RentalStart;
    public Date RentalEnd;

    /**
     * Retrieves the price of the rental.
     *
     * @return the price of the rental
     */
    public float getRentalPrice() {
        return RentalPrice;
    }
    /**
     * Sets the price of the rental.
     *
     * @param rentalPrice the price of the rental to set
     */
    public void setRentalPrice(float rentalPrice) {
        RentalPrice = rentalPrice;
    }
    /**
     * Retrieves the cars associated with the rental.
     *
     * @return the list of cars belonging to the rental
     */
    public ArrayList<Car> getCars() {
        return Cars;
    }
    /**
     * Sets the cars associated with the rental.
     *
     * @param cars the list of cars to set for the rental
     */
    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }
    /**
     * Gets the end date associated with the rental.
     *
     * @return the end date of the rental
     */
    public Date getRentalEnd() { return RentalEnd;}
    /**
     * Sets the end date associated with the rental.
     *
     * @param rentalEnd the date the rental of the car ends
     */
    public void setRentalEnd(Date rentalEnd) {RentalEnd = rentalEnd;}
    /**
     * Gets the start date associated with the rental.
     *
     * @return the start date of the rental
     */
    public Date getRentalStart() {return RentalStart;}
    /**
     * Sets the start date associated with the rental.
     *
     * @param rentalStart the date the rental of the car starts
     */
    public void setRentalStart(Date rentalStart) {RentalStart = rentalStart;}

}
