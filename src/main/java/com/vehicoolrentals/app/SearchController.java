package com.vehicoolrentals.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        if (vehicleName != null) {
            String endpointAndQueryParams = "vehicles/getmanufacturerdetails/" + vehicleName + "?format=json";
            String jsonData = carApiClient.pingApi(endpointAndQueryParams);
            model.addAttribute("jsonData", jsonData);
        }

        if (vehicleName == null && yearOfModel == null && price == null) {
            // Return to search page if all search parameters are empty
            model.addAttribute("message", "Please enter at least one search parameter.");
            return "search";
        }

        // Perform the search using the CarApiClient
        if (Objects.requireNonNull(vehicleName).isBlank() && Objects.requireNonNull(yearOfModel).isBlank() && price.isBlank()) {
            // Return to search page if all search parameters are empty
            model.addAttribute("message", "Please enter at least one search parameter.");
            return "search";
        }

        // Create a map to hold the query parameters
        Map<String, String> queryParams = new HashMap<>();
        if (!vehicleName.isBlank()) {
            queryParams.put("vehicleName", vehicleName);
        }
        if (!yearOfModel.isBlank()) {
            queryParams.put("yearOfModel", yearOfModel);
        }
        if (!price.isBlank()) {
            queryParams.put("price", price);
        }
        if (price.isBlank() && yearOfModel.isBlank() && !vehicleName.isBlank()) {
            queryParams.put("vehicleName", vehicleName);
            String searchResult = carApiClient.pingApi("/vehicles/GetMakeForManufacturer/");
            model.addAttribute("searchResult", searchResult);
            return "search_result";
        }

        return "search_result";
    }
}
// Compare this snippet from src\main\resources\templates\search.html: