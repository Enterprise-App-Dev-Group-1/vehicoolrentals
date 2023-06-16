package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
public class CarController {
    private final CarApiClient carApiClient;

    public CarController(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
    }

    @GetMapping("/car")
    public String carPage(Model model) {
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
        model.addAttribute("apiKey", apiKey);

        // Make the API call and retrieve car information
        try {
            String carInfo = carApiClient.getCarInformation(apiKey);
            // Set the car information in the model
            model.addAttribute("carInfo", carInfo);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "car";
    }
}