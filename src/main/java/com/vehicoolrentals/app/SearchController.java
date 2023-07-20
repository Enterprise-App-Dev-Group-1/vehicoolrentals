package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The SearchController class is a Spring MVC controller responsible for handling search-related requests.
 */
@Controller
public class SearchController {
    /**
     * Handles the request to the "/search" URL and returns the search page.
     *
     * @param model the Model object to populate with data
     * @return the name of the view to render
     */
    @GetMapping("/search")
    public String carPage(Model model) {
        model.addAttribute("content", "search");
        model.addAttribute("message", "Search for a car \n(VIN, Make, Model, Year)");
        return "layout";
    }
}