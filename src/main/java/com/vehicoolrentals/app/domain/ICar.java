package com.vehicoolrentals.app.domain;

import java.util.Date;

public interface ICar {
    float getCarPrice();

    void setCarPrice(float carPrice);

    String getCarImage();

    void setCarImage(String carImage);

    int getPassengers();

    void setPassengers(int passengers);

    String getCarLocation();

    void setCarLocation(String carLocation);

    String getCarDimensions();

    void setCarDimensions(String carDimensions);

    Date getAvailabilityStart();

    void setAvailabilityStart(Date availabilityStart);

    Date getAvailabilityEnd();

    void setAvailabilityEnd(Date availabilityEnd);

    // Getters and setters
    int getId();

    void setId(int id);

    String getMake();

    void setMake(String make);

    String getModel();

    void setModel(String model);

    int getYear();

    void setYear(int year);
}
