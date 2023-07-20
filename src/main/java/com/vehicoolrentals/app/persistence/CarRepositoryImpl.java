package com.vehicoolrentals.app.persistence;

import com.vehicoolrentals.app.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The CarRepository class is responsible for managing car data and provides methods to retrieve cars by ID.
 */
@Repository
public class CarRepositoryImpl extends CarRepository {

    public CarRepositoryImpl(List<Car> cars) {
    }

    /**
     * Finds a car by its ID.
     *
     * @param carId the ID of the car to find
     * @return the car with the given ID, or null if not found
     */
    public Car findById(int carId) {
        // Call the API using the CarApiClient to get the car information by ID
        // You can implement the API call using the carApiClient.pingApi() method with appropriate parameters
        // For this example, let's just return a dummy Car object.
        return new Car(carId, "Dummy Make", "Dummy Model", 0);
    }
}