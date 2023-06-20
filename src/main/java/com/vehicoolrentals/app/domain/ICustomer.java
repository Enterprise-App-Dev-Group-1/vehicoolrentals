package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

public interface ICustomer extends IUser {
    ArrayList<Rental> getRentals();

    void setRentals(ArrayList<Rental> rentals);
}
