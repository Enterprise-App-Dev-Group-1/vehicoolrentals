package com.vehicoolrentals.app;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
    public String carPage(@RequestParam("vin") String vin, Model carModel) {
        Properties config = new Properties();
        try (InputStream inputStream = CarController.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String apiKey = config.getProperty("api.key");
        carModel.addAttribute("apiKey", apiKey);

        String endpointAndQueryParams = "vehicles/DecodeVin/" + vin + "?format=json";
        String carInfo = carApiClient.pingApi(endpointAndQueryParams);

        CarData carData = gson.fromJson(carInfo, CarData.class);
        int year = carData.getYear();
        String make = carData.getMake();
        String model = carData.getModel();
        double price = carData.getTrims()[0].getMsrp();

        Car car = new Car(year, make, model, price);
        carModel.addAttribute("car", car);

        return "layout";
    }

    @GetMapping("/car_details/{id}")
    public String carDetailsPage(@PathVariable("id") String manufacturerId, Model carModel) {
        String apiUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/GetVehicleTypesForMakeId/" + manufacturerId + "?format=xml";
        String xmlResponse = fetchDataFromApi(apiUrl);
        Car carDetails = parseXmlResponse(xmlResponse);
        carModel.addAttribute("carDetails", carDetails);
        return "car_details";
    }

    private String fetchDataFromApi(String apiUrl) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, String.class);
    }

    private Car parseXmlResponse(String xmlResponse) {
        // Parse XML response and return a CarDetails object
        // For simplicity, I'm returning a dummy CarDetails object here
        return new Car(2021, "Dummy Make", "Dummy Model", 0);
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