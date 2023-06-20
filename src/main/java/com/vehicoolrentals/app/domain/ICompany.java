package com.vehicoolrentals.app.domain;

import java.util.ArrayList;

public interface ICompany extends IUser {
    ArrayList<Car> getCars();

    void setCars(ArrayList<Car> cars);
}
