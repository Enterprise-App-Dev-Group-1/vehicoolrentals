package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.CarApiClient;
import com.vehicoolrentals.app.domain.Car;

import java.time.LocalDate;

/**
 * The CarApiRepository class is responsible for managing car data using the CarApiClient and provides methods
 * to retrieve cars by ID.
 */
public class CarApiRepository extends CarRepository {
    private final CarApiClient carApiClient;

    /**
     * Constructs a CarApiRepository with the given CarApiClient.
     *
     * @param carApiClient the CarApiClient to use for retrieving car data
     */
    public CarApiRepository(CarApiClient carApiClient) {
        super();
        this.carApiClient = carApiClient;
    }

    /**
     * Finds a car by its ID using the CarApiClient.
     *
     * @param carId the ID of the car to find
     * @return the car with the given ID, or null if not found
     */
    @Override
    public Car findById(int carId) {
        String carData = carApiClient.getCarData(carId);
        return parseCarDataFromJson(carData);
    }

    @Override
    public boolean checkAvailability(int carId, LocalDate startDate, LocalDate endDate) {
        return false;
    }

    /**
     * Parses car data from a JSON string and returns a Car object.
     *
     * @param carData the JSON string representing car data
     * @return the parsed Car object
     */
    private Car parseCarDataFromJson(String carData) {
        return null; // Replace this with your logic to parse the JSON string and return a Car object
    }
}