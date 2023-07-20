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

    private String apiKey;

    /**
     * Retrieves the API key used to access the car API.
     *
     * @return the API key
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the API key used to access the car API.
     *
     * @param apiKey the API key to set
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Authenticates the API key if it is invalid or blank.
     * If the API key is null or empty, this method attempts to authenticate it by setting the provided API key.
     * If the API key is valid or has already been set, this method will not perform any action.
     *
     * @throws IllegalArgumentException if the API key is blank (empty or contains only whitespace)
     */
    public void authenticateApi() {
        // Check if the provided apiKey is valid and not blank
        if (apiKey == null || apiKey.trim().isEmpty()) {
            System.out.println("Invalid or blank API key. Authenticating...");
            // Perform authentication logic here (if required)
            // For example, you can make a request to a server to validate the API key.
            // For demonstration purposes, let's simply set the provided apiKey.
            setApiKey(apiKey);
        } else {
            System.out.println("API key is valid.");
        }
    }

    /**
     * Retrieves car information from the car API using the provided API key.
     *
     * @return the response body containing the car information
     * @throws IOException          if an I/O error occurs while sending the request
     * @throws InterruptedException if the operation is interrupted while sending the request
     */
    public String pingApi(String apiKey) throws IOException, InterruptedException {
        // Create an instance of HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Create an HttpRequest with the necessary headers and URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://car-api2.p.rapidapi.com/api/"))
                .header("X-RapidAPI-Key", getApiKey())
                .header("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
                .build();

        // Send the request and retrieve the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        return response.body();
    }

    /**
     * Sends an API request with additional data segments to the car API.
     * The additional data segments are used to customize the API request based on the API's endpoints and parameters.
     *
     * @param segments the additional data segments to be appended to the base URI
     * @throws IOException            if an I/O error occurs while sending the request
     * @throws InterruptedException   if the operation is interrupted while sending the request
     * @throws IllegalArgumentException if any of the segments is blank (empty or contains only whitespace)
     */
    public void pingApiWithAdditionalData(String... segments) throws IOException, InterruptedException {
        // Create an instance of HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Construct the complete URI with additional data
        StringBuilder uriBuilder = new StringBuilder("https://car-api2.p.rapidapi.com/api/");
        for (String segment : segments) {
            uriBuilder.append(segment).append("/");
        }

        // Create an HttpRequest with the necessary headers and the modified URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriBuilder.toString()))
                .header("X-RapidAPI-Key", getApiKey())
                .header("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
                .build();

        // Send the request and retrieve the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Return the response body
        response.body();
    }
}
