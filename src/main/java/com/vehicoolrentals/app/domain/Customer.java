package com.vehicoolrentals.app.domain;
import java.util.ArrayList;

/**
 * The Customer class represents a customer entity that extends the User class and implements the ICustomer interface.
 */
public class Customer extends User implements ICustomer {
    public ArrayList<Rental> Rentals;

    /**
     * Retrieves the rentals associated with the customer.
     *
     * @return the list of rentals belonging to the customer
     */
    @Override
    public ArrayList<Rental> getRentals() {
        return Rentals;
    }

    /**
     * Sets the rentals associated with the customer.
     *
     * @param rentals the list of rentals to set for the customer
     */
    @Override
    public void setRentals(ArrayList<Rental> rentals) {
        Rentals = rentals;
    }
}
