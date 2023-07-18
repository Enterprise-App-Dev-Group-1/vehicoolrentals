package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

/**
 * The Company class represents a company entity that extends the User class and implements the ICompany interface.
 */
public class Company extends User implements ICompany {

    public ArrayList<Car> Cars;

    /**
     * Retrieves the cars associated with the company.
     *
     * @return the list of cars belonging to the company
     */
    @Override
    public ArrayList<Car> getCars() {
        return Cars;
    }

    /**
     * Sets the cars associated with the company.
     *
     * @param cars the list of cars to set for the company
     */
    @Override
    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }
}
