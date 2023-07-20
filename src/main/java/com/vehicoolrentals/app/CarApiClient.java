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
     * Retrieves car information from the car API using the provided segments.
     *
     * @param segments the additional data segments to be appended to the base URI
     * @return the response body containing the car information
     * @throws IOException          if an I/O error occurs while sending the request
     * @throws InterruptedException if the operation is interrupted while sending the request
     * @throws IllegalArgumentException if any of the segments is blank (empty or contains only whitespace)
     */
    public String pingApi(String... segments) throws IOException, InterruptedException {
        // Create an instance of HttpClient
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Construct the complete URI with additional data segments
        StringBuilder uriBuilder = new StringBuilder("https://vpic.nhtsa.dot.gov/api/");
        for (String segment : segments) {
            if (segment.isBlank()) {
                throw new IllegalArgumentException("Segment cannot be blank.");
            }
            uriBuilder.append(segment).append("/");
        }

        // Create an HttpRequest with the necessary headers and the modified URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriBuilder.toString()))
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

        // Construct the complete URI with additional data segments
        StringBuilder uriBuilder = new StringBuilder("https://vpic.nhtsa.dot.gov/api/");
        for (String segment : segments) {
            if (segment.isBlank()) {
                throw new IllegalArgumentException("Segment cannot be blank.");
            }
            uriBuilder.append(segment).append("/");
        }

        // Create an HttpRequest with the necessary headers and the modified URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriBuilder.toString()))
                .build();

        // Send the request and retrieve the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Process the response here if needed
    }

    /**
     * Retrieves a car from the car API using the provided ID.
     *
     * @return the car object if found, or null if not found
     */

    // Implement the mock behavior to return a dummy JSON response for VIN decoding
    public String pingApi(String endpoint, String requestBody) {
        return null;
    }

    public String getCarData(int carId) {
        return null;
    }
}
// Compare this snippet from src\main\java\com\vehicoolrentals\app\persistence\CarRepository.java: