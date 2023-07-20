package com.vehicoolrentals.app;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The CarApiClient class is responsible for interacting with a car API to retrieve car information.
 */
@Component
public class CarApiClient {

    public String pingApi(String endpointAndQueryParams) {
        // Build the API URL
        String apiUrl = "https://vpic.nhtsa.dot.gov/api/" + endpointAndQueryParams;

        try {
            // Open a connection to the API URL
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the API call was successful (HTTP status 200)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                connection.disconnect();

                return response.toString();
            } else {
                // Handle the API error response here if needed
                // For simplicity, we'll return an empty string in case of an error
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception here if needed
            // For simplicity, we'll return an empty string in case of an error
            return "";
        }
    }

    public String getCarData(int carId) {
        return null;
    }
}