package com.vehicoolrentals.app.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

/**
 * The Car class represents a car entity with its properties and implements the ICar interface.
 */
public class Car implements ICar {
    private int Id;
    private String Make;
    private String Model;
    private int Year;
    public String CarImage;
    public int Passengers;
    public String CarLocation;
    public String CarDimensions;
    public Date AvailabilityStart;
    public Date AvailabilityEnd;
    public float CarPrice;

    /**
     * Constructs a Car object with the specified ID, make, model, and year.
     *
     * @param id    the ID of the car
     * @param make  the make of the car
     * @param model the model of the car
     * @param year  the year of the car
     */
    public Car(int id, String make, String model, int year) {
        this.Id = id;
        this.Make = make;
        this.Model = model;
        this.Year = year;
    }

    /**
     * Constructs a Car object with the specified properties.
     *
     * @param id                the ID of the car
     * @param make              the make of the car
     * @param model             the model of the car
     * @param year              the year of the car
     * @param carImage          the image of the car
     * @param passengers        the number of passengers the car can accommodate
     * @param carLocation       the location of the car
     * @param carDimensions     the dimensions of the car
     * @param availabilityStart the start date of the car's availability
     * @param availabilityEnd   the end date of the car's availability
     * @param carPrice          the price of the car
     */
    public Car(int id, String make, String model, int year, String carImage, int passengers, String carLocation, String carDimensions, Date availabilityStart, Date availabilityEnd, float carPrice) {
        this.Id = id;
        this.Make = make;
        this.Model = model;
        this.Year = year;
        CarImage = carImage;
        Passengers = passengers;
        CarLocation = carLocation;
        CarDimensions = carDimensions;
        AvailabilityStart = availabilityStart;
        AvailabilityEnd = availabilityEnd;
        CarPrice = carPrice;
    }

    @Override
    public float getCarPrice () {
        return CarPrice;
    }
    @Override
    public void setCarPrice(float carPrice) {
        this.CarPrice = carPrice;
    }

    @Override
    public String getCarImage() {
        return CarImage;
    }

    @Override
    public void setCarImage(String carImage) {
        this.CarImage = carImage;
    }

    @Override
    public int getPassengers() {
        return Passengers;
    }

    @Override
    public void setPassengers(int passengers) {
        this.Passengers = passengers;
    }

    @Override
    public String getCarLocation() {
        return CarLocation;
    }

    @Override
    public void setCarLocation(String carLocation) {
        this.CarLocation = carLocation;
    }

    @Override
    public String getCarDimensions() {
        return CarLocation;
    }

    @Override
    public void setCarDimensions(String carDimensions) {
        this.CarDimensions = carDimensions;
    }

    @Override
    public Date getAvailabilityStart() {
        return AvailabilityStart;
    }

    @Override
    public void setAvailabilityStart(Date availabilityStart) {
        this.AvailabilityStart = availabilityStart;
    }

    @Override
    public Date getAvailabilityEnd() {
        return AvailabilityEnd;
    }

    @Override
    public void setAvailabilityEnd(Date availabilityEnd) {
        this.AvailabilityEnd = availabilityEnd;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        this.Id = id;
    }

    @Override
    public String getMake() {
        return Make;
    }

    @Override
    public void setMake(String make) {
        this.Make = make;
    }

    @Override
    public String getModel() {
        return Model;
    }

    @Override
    public void setModel(String model) {
        this.Model = model;
    }

    @Override
    public int getYear() {
        return Year;
    }

    @Override
    public void setYear(int year) {
        this.Year = year;
    }
}

