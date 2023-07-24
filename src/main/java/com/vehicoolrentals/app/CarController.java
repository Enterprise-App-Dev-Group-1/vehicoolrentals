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
import java.io.StringReader;
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

        Car carData = gson.fromJson(carInfo, Car.class);

        float estimatedPrice = 0;
        // Estimate the price based on the make and model
        estimatedPrice = (float) carData.getPrice(estimatedPrice, carData.getMake(), carData.getModel());

        carData.getPrice(estimatedPrice, carData.getMake(), carData.getModel());

        carModel.addAttribute("car", carData);

        return "layout";
    }


    @GetMapping("/car_details/{id}")
    public String carDetailsPage(@PathVariable("id") String manufacturerId, Model carModel) {
        String apiUrl = "https://vpic.nhtsa.dot.gov/api/vehicles/GetMakesForManufacturerAndYear/" + manufacturerId + "?year=2014&format=xml";
        String xmlResponse = fetchDataFromApi(apiUrl);
        Car carDetails = parseXmlResponse(xmlResponse);

        if (carDetails != null) {
            carModel.addAttribute("carDetails", carDetails);
        }

        return "car_details";
    }

    private String fetchDataFromApi(String apiUrl) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(apiUrl, String.class);
    }

    private Car parseXmlResponse(String xmlResponse) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xmlResponse));
            Document document = builder.parse(inputSource);

            String makeName = document.getElementsByTagName("MakeName").item(0).getTextContent();
            String modelName = document.getElementsByTagName("MakeName").item(1).getTextContent();

            return new Car(2023, makeName, modelName, 25000.00);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public class Car {
        private int year;
        private String make;
        private String model;
        private double price;
        private int makeId;
        private String manufacturerName;

        public Car(int year, String make, String model, double price) {
            this.year = year;
            this.make = make;
            this.model = model;
            this.price = price;
            this.makeId = makeId;
            this.manufacturerName = manufacturerName;
        }

        public double getPrice() {
            getPrice(0, "", "");
            return price;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }

        // Method to get the price based on make, model, and year
        public double getPrice(float estimatedPrice, String make, String model) {
            // Assign base price for each make and model (these are arbitrary values and can be adjusted)
            float basePrice = 15000.0f; // Base price for most cars

            // Make and model specific price estimations
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
            com.vehicoolrentals.app.domain.Car carData = new com.vehicoolrentals.app.domain.Car(make, model, 0);
            int age = currentYear - carData.getYear();
            basePrice = (float) (basePrice/0.02);
            if (age > 0) {
                // Apply a depreciation factor of 5% per year for older cars
                float depreciationFactor = 1.0f - (0.05f * age);
                return basePrice * depreciationFactor;
            } else {
                return basePrice;
            }
        }

        @Override
        public String toString() {
            return "Car{" +
                    "year=" + year +
                    ", make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    ", price=" + price +
                    ", makeId=" + makeId +
                    ", manufacturerName='" + manufacturerName + '\'' +
                    '}';
        }
    }
}