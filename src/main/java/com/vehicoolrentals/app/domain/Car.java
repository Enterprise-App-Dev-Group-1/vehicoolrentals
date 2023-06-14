package com.vehicoolrentals.app.domain;

public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters and setters
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }
}

