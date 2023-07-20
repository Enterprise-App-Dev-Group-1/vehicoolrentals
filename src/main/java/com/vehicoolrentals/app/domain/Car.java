package com.vehicoolrentals.app.domain;

import java.util.Date;

/**
 * The Car class represents a car entity with its properties and implements the ICar interface.
 */
public class Car implements ICar {

    // MySql Database id
    private int id;

    // Vim for CarApi
    private String vim;

    private String make;
    private String model;
    private int year;
    public String carImage;
    public int passengers;
    public String carLocation;
    public String carDimensions;
    public Date availabilityStart;
    public Date AvailabilityEnd;
    public float carPrice;

    /**
     * Constructs a Car object with the specified ID, make, model, and year.
     *
     * @param id    the ID of the car
     * @param make  the make of the car
     * @param model the model of the car
     * @param year  the year of the car
     */
    public Car(int id, String vim, String make, String model, int year) {
        this.id = id;
        this.vim = vim;
        this.make = make;
        this.model = model;
        this.year = year;
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
    public Car(int id, String vim, String make, String model, int year, String carImage, int passengers, String carLocation, String carDimensions, Date availabilityStart, Date availabilityEnd, float carPrice) {
        this.id = id;
        this.vim = vim;
        this.make = make;
        this.model = model;
        this.year = year;
        this.carImage = carImage;
        this.passengers = passengers;
        this.carLocation = carLocation;
        this.carDimensions = carDimensions;
        this.availabilityStart = availabilityStart;
        AvailabilityEnd = availabilityEnd;
        this.carPrice = carPrice;
    }

    @Override
    public float getCarPrice () {
        return carPrice;
    }
    @Override
    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String getCarImage() {
        return carImage;
    }

    @Override
    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public String getCarLocation() {
        return carLocation;
    }

    @Override
    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    @Override
    public String getCarDimensions() {
        return carLocation;
    }

    @Override
    public void setCarDimensions(String carDimensions) {
        this.carDimensions = carDimensions;
    }

    @Override
    public Date getAvailabilityStart() {
        return availabilityStart;
    }

    @Override
    public void setAvailabilityStart(Date availabilityStart) {
        this.availabilityStart = availabilityStart;
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
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getVim() {
        return vim;
    }

    @Override
    public void setVim(String vim) {
        this.vim = vim;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }
}

