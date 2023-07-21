package com.vehicoolrentals.app.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.vehicoolrentals.app.CarApiClient;

import java.io.IOException;
import java.util.Date;

public class Car implements ICar {

    private final CarApiClient carApiClient;

    private String vin; // Changed 'vin' to 'vin'
    private int year;
    private String imageUrl; 
    private int capacity; 
    private String location; 
    private String dimensions;
    private Date availabilityStart;
    private Date availabilityEnd;
    private float price;

    public Car(CarApiClient carApiClient, int carId, String dummyMake, String dummyModel, int i) {
        this.carApiClient = carApiClient;
    }

    public Car(int carId, String dummyMake, String dummyModel, int i) {
        this.carApiClient = null;
    }

    @Override
    public float getCarPrice() {
        return 0;
    }

    @Override
    public void setCarPrice(float carPrice) {

    }

    @Override
    public String getCarImage() {
        return null;
    }

    @Override
    public void setCarImage(String carImage) {

    }

    @Override
    public int getPassengers() {
        return 0;
    }

    @Override
    public void setPassengers(int passengers) {

    }

    @Override
    public String getCarLocation() {
        return null;
    }

    @Override
    public void setCarLocation(String carLocation) {

    }

    @Override
    public String getCarDimensions() {
        return null;
    }

    @Override
    public void setCarDimensions(String carDimensions) {

    }

    @Override
    public float getprice() {
        return 0;
    }

    @Override
    public void setprice(float price) {

    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDimensions() {
        return dimensions;
    }

    @Override
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
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
    public void setId(int id) {
    }

    @Override
    public String getVin() {
        return vin;
    }

    @Override
    public void setVin(String vin) {
        this.vin = vin;
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
    }

    @Override
    public String getId() {
        String endpoint = "/vehicles/DecodeVin/" + vin + "?format=json&modelyear=" + year;
        String response = carApiClient.pingApi(endpoint);
        return parseMakeIdFromJson(response);
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
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    // Additional field to store the manufacturer ID (MakeID) obtained from the NHTSA API
    private String makeId;

    // Method to fetch and set the manufacturer ID (MakeID) from the NHTSA API
    private void setMakeIdFromNhtsaApi() {
        try {
            // Build the API endpoint with the VIN and year
            String endpoint = "/vehicles/DecodeVin/" + vin + "?format=json&modelyear=" + year;
            // Make the API call and get the JSON response
            String response = carApiClient.pingApi(endpoint);
            // Parse the JSON response to get the MakeID and store it in the makeId field
            this.makeId = parseMakeIdFromJson(response);
        } catch (Exception e) {
            e.printStackTrace();
            this.makeId = ""; // Set makeId to an empty string in case of an error
        }
    }

    // Define the class representing the JSON response structure for the NHTSA API
// You may need to modify the class to match the actual JSON response structure
    private static class NhtsaApiResponse {
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

    // Method to parse the JSON response from the NHTSA API and extract the manufacturer ID (MakeID)
    private String parseMakeIdFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the MakeID
            Gson gson = new Gson();
            NhtsaApiResponse response = gson.fromJson(json, NhtsaApiResponse.class);
            return response.getMakeID();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Method to parse the JSON response from the NHTSA API and extract the manufacturer name (Make)
    private String parseMakeFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the Make
            Gson gson = new Gson();
            NhtsaApiResponse response = gson.fromJson(json, NhtsaApiResponse.class);
            return response.getMake();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // Method to parse the JSON response from the NHTSA API and extract the model name (Model)
    private String parseModelFromJson(String json) {
        try {
            // Use Gson to parse the JSON response and extract the Model
            Gson gson = new Gson();
            NhtsaApiResponse response = gson.fromJson(json, NhtsaApiResponse.class);
            return response.getModel();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public void getModelYear() {
    }

    public void setModelYear(int i) {
        getModelYear();
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
