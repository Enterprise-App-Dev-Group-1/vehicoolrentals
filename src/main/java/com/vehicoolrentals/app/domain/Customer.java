package com.vehicoolrentals.app.domain;
import java.util.ArrayList;

public class Customer extends User implements ICustomer {
    public ArrayList<Rental> Rentals;

    @Override
    public ArrayList<Rental> getRentals() {
        return Rentals;
    }

    @Override
    public void setRentals(ArrayList<Rental> rentals) {
        Rentals = rentals;
    }
}
