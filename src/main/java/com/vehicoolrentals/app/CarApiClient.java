package com.vehicoolrentals.app;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * The CarApiClient class is responsible for interacting with a car API to retrieve car information.
 */
@Component
public class CarApiClient {
    /**
     * Retrieves car information from the car API using the provided API key.
     *
     * @param apiKey the API key to access the car API
     * @return the response body containing the car information
     * @throws IOException        if an I/O error occurs while sending the request
     * @throws InterruptedException if the operation is interrupted while sending the request
     */
    public String getCarInformation(String apiKey) throws IOException, InterruptedException {
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

        // Return the response body
        return response.body();
    }
}
