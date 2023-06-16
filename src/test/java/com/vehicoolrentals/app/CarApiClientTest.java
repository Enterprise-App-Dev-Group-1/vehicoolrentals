package com.vehicoolrentals.app;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CarApiClientTest {

    @Test
    public void testCarApi() throws Exception {
        // Read the API key from the config file
        String apiKey = readApiKeyFromConfig();
    }

    private String readApiKeyFromConfig() throws IOException {
        Properties properties = new Properties();

        // Load the config.properties file
        try (InputStream input = CarApiClientTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }

        // Retrieve the value of the 'api.key' property
        String apiKey = properties.getProperty("api.key");

        if (apiKey == null) {
            throw new IllegalStateException("API key not found in the config.properties file.");
        }

        return apiKey.trim();
    }
}