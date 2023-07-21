package com.vehicoolrentals.app.domain;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.vehicoolrentals.app.CarApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
    // Method to get the price based on make, model, and year
    public float getPrice(String make, String model, int year) {
        // Assign base price for each make and model (these are arbitrary values and can be adjusted)
        float basePrice = 15000.0f; // Base price for most cars

        // Add more make and model specific price estimations as needed
        // I COULD NOT for the life of me find a suitable yet FREE API for
        // finding the price, so I regret to present
        // "YandreDev if-else statement hell"
        // College students (me) are broke
        if (make.equalsIgnoreCase("Toyota")) {
            if (model.equalsIgnoreCase("Corolla")) {
                basePrice = 18000.0f;
            } else if (model.equalsIgnoreCase("Camry")) {
                basePrice = 20000.0f;
            } else if (model.equalsIgnoreCase("RAV4")) {
                basePrice = 22000.0f;
            } else if (model.equalsIgnoreCase("Highlander")) {
                basePrice = 25000.0f;
            } else if (model.equalsIgnoreCase("Sienna")) {
                basePrice = 28000.0f;
            } // Add more Toyota models and their respective base prices
        } else if (make.equalsIgnoreCase("Honda")) {
            if (model.equalsIgnoreCase("Civic")) {
                basePrice = 17000.0f;
            } else if (model.equalsIgnoreCase("Accord")) {
                basePrice = 19000.0f;
            } else if (model.equalsIgnoreCase("CR-V")) {
                basePrice = 21000.0f;
            } else if (model.equalsIgnoreCase("Pilot")) {
                basePrice = 24000.0f;
            } else if (model.equalsIgnoreCase("Odyssey")) {
                basePrice = 26000.0f;
            } // Add more Honda models and their respective base prices
        } else if (make.equalsIgnoreCase("Ford")) {
            if (model.equalsIgnoreCase("Focus")) {
                basePrice = 16000.0f;
            } else if (model.equalsIgnoreCase("Fusion")) {
                basePrice = 18000.0f;
            } else if (model.equalsIgnoreCase("Escape")) {
                basePrice = 20000.0f;
            } else if (model.equalsIgnoreCase("Explorer")) {
                basePrice = 23000.0f;
            } else if (model.equalsIgnoreCase("Expedition")) {
                basePrice = 26000.0f;
            } // Add more Ford models and their respective base prices
        } else if (make.equalsIgnoreCase("Chevrolet")) {
            if (model.equalsIgnoreCase("Malibu")) {
                basePrice = 19000.0f;
            } else if (model.equalsIgnoreCase("Equinox")) {
                basePrice = 21000.0f;
            } else if (model.equalsIgnoreCase("Silverado")) {
                basePrice = 25000.0f;
            } else if (model.equalsIgnoreCase("Tahoe")) {
                basePrice = 28000.0f;
            } else if (model.equalsIgnoreCase("Suburban")) {
                basePrice = 30000.0f;
            } // Add more Chevrolet models and their respective base prices
        } // Add more make and model specific price estimations for other car makes

        // Adjust price based on the year (assuming a linear depreciation model)
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - year;
        if (age > 0) {
            // Apply a depreciation factor of 5% per year for older cars
            float depreciationFactor = 1.0f - (0.05f * age);
            return basePrice * depreciationFactor;
        } else {
            return basePrice;
        }
    }

    private float pricePerDay;

    public float getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public void setPrice(float basePrice) {

        // Assume price per day is 2% of the base price (adjust value as needed)
        float reasonableAmountPerDay = 0.02f; // 2% of the base price
        this.pricePerDay = basePrice * reasonableAmountPerDay;
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
