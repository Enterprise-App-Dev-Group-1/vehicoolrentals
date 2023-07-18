package com.vehicoolrentals.app.domain;

import java.util.Date;

/**
 * The ICar interface defines the properties and methods for a car entity.
 */
public interface ICar {
    /**
     * Retrieves the price of the car.
     *
     * @return the price of the car
     */
    float getCarPrice();

    /**
     * Sets the price of the car.
     *
     * @param carPrice the price of the car to set
     */
    void setCarPrice(float carPrice);

    /**
     * Retrieves the image of the car.
     *
     * @return the image of the car
     */
    String getCarImage();

    /**
     * Sets the image of the car.
     *
     * @param carImage the image of the car to set
     */
    void setCarImage(String carImage);

    /**
     * Retrieves the number of passengers the car can accommodate.
     *
     * @return the number of passengers the car can accommodate
     */
    int getPassengers();

    /**
     * Sets the number of passengers the car can accommodate.
     *
     * @param passengers the number of passengers to set
     */
    void setPassengers(int passengers);

    /**
     * Retrieves the location of the car.
     *
     * @return the location of the car
     */
    String getCarLocation();

    /**
     * Sets the location of the car.
     *
     * @param carLocation the location of the car to set
     */
    void setCarLocation(String carLocation);

    /**
     * Retrieves the dimensions of the car.
     *
     * @return the dimensions of the car
     */
    String getCarDimensions();

    /**
     * Sets the dimensions of the car.
     *
     * @param carDimensions the dimensions of the car to set
     */
    void setCarDimensions(String carDimensions);

    /**
     * Retrieves the start date of the car's availability.
     *
     * @return the start date of the car's availability
     */
    Date getAvailabilityStart();

    /**
     * Sets the start date of the car's availability.
     *
     * @param availabilityStart the start date of the car's availability to set
     */
    void setAvailabilityStart(Date availabilityStart);

    /**
     * Retrieves the end date of the car's availability.
     *
     * @return the end date of the car's availability
     */
    Date getAvailabilityEnd();

    /**
     * Sets the end date of the car's availability.
     *
     * @param availabilityEnd the end date of the car's availability to set
     */
    void setAvailabilityEnd(Date availabilityEnd);

    /**
     * Retrieves the ID of the car.
     *
     * @return the ID of the car
     */
    int getId();

    /**
     * Sets the ID of the car.
     *
     * @param id the ID of the car to set
     */
    void setId(int id);

    /**
     * Retrieves the make of the car.
     *
     * @return the make of the car
     */
    String getMake();

    /**
     * Sets the make of the car.
     *
     * @param make the make of the car to set
     */
    void setMake(String make);

    /**
     * Retrieves the model of the car.
     *
     * @return the model of the car
     */
    String getModel();

    /**
     * Sets the model of the car.
     *
     * @param model the model of the car to set
     */
    void setModel(String model);

    /**
     * Retrieves the year of the car.
     *
     * @return the year of the car
     */
    int getYear();

    /**
     * Sets the year of the car.
     *
     * @param year the year of the car to set
     */
    void setYear(int year);
}
