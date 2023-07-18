package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The RentalsController class is a Spring MVC controller responsible for handling rentals-related requests.
 */
@Controller
public class RentalsController {
    /**
     * Handles the request to the "/rentals" URL and returns the rentals page.
     *
     * @param model the Model object to populate with data
     * @return the name of the view to render
     */
    @GetMapping("/rentals")
    public String carPage(Model model) {
        model.addAttribute("content", "rentals");
        model.addAttribute("message", "Rentals Page Placeholder");
        return "layout";
    }
}