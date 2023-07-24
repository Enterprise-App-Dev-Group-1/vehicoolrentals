package com.vehicoolrentals.app;

import com.vehicoolrentals.app.domain.Car;
import com.vehicoolrentals.app.domain.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class RentalsController {
    private ArrayList<Rental> rentals = new ArrayList<>(); // This will hold all rentals (You may use a database in a real application)

    /**
     * Handles the request to the "/rentals" URL and returns the rentals page.
     *
     * @param model the Model object to populate with data
     * @return the name of the view to render
     */
    @GetMapping("/rentals")
    public String carPage(Model model) {
        model.addAttribute("rentals", rentals);
        return "rentals";
    }

    /**
     * Handles the request to rent a specific car identified by its ID.
     *
     * @param carId the ID of the car to rent
     * @return the name of the view to render
     */
    @PostMapping("/rent/{carId}")
    public String rentCar(@PathVariable int carId) throws IOException, InterruptedException {
        Car carToRent = new Car("Car Brand", "Car Model", 2023); // Create a new Car object
        carToRent.setId(carId);
        carToRent.setMake(carToRent.getMake());
        carToRent.setModel(carToRent.getModel());
        carToRent.setYear(carToRent.getYear());

        // Create a new Rental object
        Rental rental = new Rental();
        rental.setRentalStart(new Date()); // Set the rental start date to the current date/time
        rental.setCars(new ArrayList<>()); // Initialize the list of cars in this rental
        rental.getCars().add(carToRent); // Add the car to the rental

        // Calculate and set the rental price based on car details (You can implement your pricing logic here)
        rental.setRentalPrice(100.0f);

        // Add the rental to the list of rentals
        rentals.add(rental);

        // Redirect the user back to the rentals page to see the updated list of rentals
        return "redirect:/rentals";
    }
}