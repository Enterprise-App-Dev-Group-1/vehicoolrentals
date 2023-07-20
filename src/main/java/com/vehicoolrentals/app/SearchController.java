package com.vehicoolrentals.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class SearchController {

    private final CarApiClient carApiClient;

    @Autowired
    public SearchController(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
    }

    @GetMapping("/search")
    public String carPage(Model model,
                          @RequestParam(value = "vehicleName", required = false) String vehicleName,
                          @RequestParam(value = "yearOfModel", required = false) String yearOfModel,
                          @RequestParam(value = "price", required = false) String price) {

        if (vehicleName == null && yearOfModel == null && price == null) {
            // Return to search page if all search parameters are empty
            model.addAttribute("message", "Please enter at least one search parameter.");
            return "search";
        }

        // Perform the search using the CarApiClient
        try {
            String searchResult = carApiClient.pingApi("some_endpoint", vehicleName, yearOfModel, price);

            // Here, you can process the API response and use it as needed.
            // For this example, we'll just add it to the model and pass it to the search_result.html template.
            model.addAttribute("searchResult", searchResult);

            return "search_result";

        } catch (IOException | InterruptedException e) {
            // Handle any exceptions that may occur during the API call.
            // For this example, we'll display an error message.
            model.addAttribute("errorMessage", "An error occurred while processing the search.");
            return "error";
        }
    }
}