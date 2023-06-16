package com.vehicoolrentals.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class CarApiClient {
    public static void main(String[] args) throws Exception {
        // Load the configuration file
        Properties config = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            // Handle configuration file loading error
            e.printStackTrace();
        }

        // Retrieve the API key from the configuration
        String apiKey = config.getProperty("api.key");

        // Create an instance of HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Create an HttpRequest with the necessary headers and URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://car-api2.p.rapidapi.com/api/vin/KNDJ23AU4N7154467"))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
                .build();

        // Send the request and retrieve the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response body
        System.out.println(response.body());
    }
}