package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

public class Company extends User implements ICompany {

    public ArrayList<Car> Cars;

    @Override
    public ArrayList<Car> getCars() {
        return Cars;
    }

    @Override
    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }
}
