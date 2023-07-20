package com.vehicoolrentals.app;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
public class CarController {
    private final CarApiClient carApiClient;
    private final Gson gson;

    public CarController(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
        this.gson = new Gson();
    }

    @GetMapping("/car")
    public String carPage(Model carModel) {
        Properties config = new Properties();
        try (InputStream inputStream = CarController.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String apiKey = config.getProperty("api.key");
        carModel.addAttribute("apiKey", apiKey);

        String vim = "1G1YY26U265100001";
        int year = 0;
        String endpointAndQueryParams = "vehicles/DecodeVin/" + vim + "?format=json&modelyear=XML" + year;
        String carInfo = carApiClient.pingApi(endpointAndQueryParams);

        CarData carData = gson.fromJson(carInfo, CarData.class);
        year = carData.getYear();
        String make = carData.getMake();
        String model = carData.getModel();
        double price = carData.getTrims()[0].getMsrp();

        Car car = new Car(year, make, model, price);
        carModel.addAttribute("car", car);

        return "layout";
    }

    public static class CarData {
        private int year;
        private String make;
        private String model;
        private TrimData[] trims;

        public int getYear() {
            return year;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public TrimData[] getTrims() {
            return trims;
        }
    }

    public static class TrimData {
        private double msrp;

        public double getMsrp() {
            return msrp;
        }
    }

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