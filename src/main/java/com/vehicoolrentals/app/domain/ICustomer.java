package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

/**
 * The ICustomer interface extends the IUser interface and defines the methods for a customer entity.
 */
public interface ICustomer extends IUser {
    /**
     * Retrieves the rentals associated with the customer.
     *
     * @return the list of rentals belonging to the customer
     */
    ArrayList<Rental> getRentals();

    /**
     * Sets the rentals associated with the customer.
     *
     * @param rentals the list of rentals to set for the customer
     */
    void setRentals(ArrayList<Rental> rentals);
}
