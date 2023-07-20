package com.vehicoolrentals.app;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The CarController class is a Spring MVC controller responsible for handling car-related requests.
 */
@Controller
public class CarController {
    private final CarApiClient carApiClient;
    private final Gson gson;

    /**
     * Constructs a CarController with the provided CarApiClient and Gson instances.
     *
     * @param carApiClient the CarApiClient instance to use for making API calls
     */
    public CarController(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
        this.gson = new Gson();
    }

    /**
     * Handles the request to the /car endpoint and returns the car page.
     *
     * @param carModel the Model object to populate with car data
     * @return the name of the view to render
     */
    @GetMapping("/car")
    public String carPage(Model carModel) {
        // Load the configuration file
        Properties config = new Properties();
        try (InputStream inputStream = CarController.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retrieve the API key from the configuration
        String apiKey = config.getProperty("api.key");

        // Set the API key in the model
        carModel.addAttribute("apiKey", apiKey);

        // Make the API call and retrieve car information
        try {
            String carInfo = carApiClient.pingApi(apiKey);

            // Parse the JSON response using Gson
            CarData carData = gson.fromJson(carInfo, CarData.class);

            // Extract the desired fields from the CarData object
            int year = carData.getYear();
            String make = carData.getMake();
            String model = carData.getModel();
            double price = carData.getTrims()[0].getMsrp();

            // Create a Car object with the extracted fields
            Car car = new Car(year, make, model, price);

            // Set the car object in the model
            carModel.addAttribute("car", car);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "layout";
    }

    /**
     * Represents the data structure for car information retrieved from the API.
     */
    public static class CarData {
        private int year;
        private String make;
        private String model;
        private TrimData[] trims;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public TrimData[] getTrims() {
            return trims;
        }

        public void setTrims(TrimData[] trims) {
            this.trims = trims;
        }
    }

    /**
     * Represents the data structure for trim information.
     */
    public static class TrimData {
        private double msrp;

        public double getMsrp() {
            return msrp;
        }

        public void setMsrp(double msrp) {
            this.msrp = msrp;
        }
    }

    /**
     * Represents a Car object with specific attributes.
     */
    public static class Car {
        private int year;
        private String make;
        private String model;
        private double price;

        public Car(int year, String make, String model, double price) {
            this.year = year;
            this.make = make;
            this.model = model;
            this.price = price;
        }

        public int getYear() {
            return year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }
    }
}