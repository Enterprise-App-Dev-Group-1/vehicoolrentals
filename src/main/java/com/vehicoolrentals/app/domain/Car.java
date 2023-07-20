package com.vehicoolrentals.app.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vehicoolrentals.app.CarApiClient;

import java.io.IOException;
import java.util.Date;

public class Car implements ICar {

    private CarApiClient carApiClient;

    private int id;
    private String vim;
    private String make;
    private String model;
    private int year;
    private String carImage;
    private int passengers;
    private String carLocation;
    private String carDimensions;
    private Date availabilityStart;
    private Date availabilityEnd;
    private float carPrice;

    public Car(int id, String vim, String make, int year) {
        this.id = id;
        this.vim = vim;
        this.make = make;
        this.model = model;
        this.year = year;
    }

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
        this.availabilityEnd = availabilityEnd;
        this.carPrice = carPrice;
    }

    @Override
    public float getCarPrice() {
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
        return carDimensions;
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
        return availabilityEnd;
    }

    @Override
    public void setAvailabilityEnd(Date availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }

    @Override
    public String getId() throws IOException, InterruptedException {
        String endpoint = "/vehicles/DecodeVin/" + vim + "?format=json&modelyear=" + year;
        String response = carApiClient.pingApi(endpoint);
        return parseMakeIdFromJson(response);
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
    public String getMake() throws IOException, InterruptedException {
        String makeId = getId();
        String endpoint = "/vehicles/GetMakesForMakeId/" + makeId + "?format=json";
        String response = carApiClient.pingApi(endpoint);
        return parseMakeFromJson(response);
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() throws IOException, InterruptedException {
        String makeId = getId();
        String endpoint = "/vehicles/GetModelsForMakeId/" + makeId + "?format=json&modelyear=" + year;
        String response = carApiClient.pingApi(endpoint);
        return parseModelFromJson(response);
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

    private String parseMakeIdFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the MakeID
            // Replace the below parsing logic with the actual Gson parsing based on your JSON response structure
            Gson gson = new Gson();
            modelResponse response = gson.fromJson(json, modelResponse.class);
            return response.getMakeID();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String parseMakeFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the Make
            // Replace the below parsing logic with the actual Gson parsing based on your JSON response structure
            Gson gson = new Gson();
            modelResponse response = gson.fromJson(json, modelResponse.class);
            return response.getMake();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String parseModelFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the Model
            // Replace the below parsing logic with the actual Gson parsing based on your JSON response structure
            Gson gson = new Gson();
            modelResponse response = gson.fromJson(json, modelResponse.class);
            return response.getModel();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Define the class representing the JSON response structure
    private static class modelResponse {
        @SerializedName("MakeID")
        private String makeID;

        @SerializedName("Make")
        private String make;

        @SerializedName("Model")
        private String model;

        // Getters for the fields

        public String getMakeID() {
            return makeID;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }
    }
}
