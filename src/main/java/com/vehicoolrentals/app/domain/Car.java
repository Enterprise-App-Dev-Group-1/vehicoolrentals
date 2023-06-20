package com.vehicoolrentals.app.domain;

import java.util.Date;

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

    public Car(int id, String make, String model, int year) {
        this.Id = id;
        this.Make = make;
        this.Model = model;
        this.Year = year;
    }

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
    public float getCarPrice() {
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

