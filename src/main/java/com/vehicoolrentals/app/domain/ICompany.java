package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

/**
 * The ICompany interface extends the IUser interface and defines the methods for a company entity.
 */
public interface ICompany extends IUser {
    /**
     * Retrieves the cars associated with the company.
     *
     * @return the list of cars belonging to the company
     */
    ArrayList<Car> getCars();

    /**
     * Sets the cars associated with the company.
     *
     * @param cars the list of cars to set for the company
     */
    void setCars(ArrayList<Car> cars);
}
