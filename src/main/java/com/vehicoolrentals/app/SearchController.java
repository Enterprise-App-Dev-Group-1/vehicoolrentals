package com.vehicoolrentals.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class SearchController {

    private final CarApiClient carApiClient;

    @Autowired
    public SearchController(CarApiClient carApiClient) {
        this.carApiClient = carApiClient;
    }

    public static class RentedCarDetails {
        private String Mfr_CommonName;
        private int Mfr_ID;
        private String Mfr_Name;
        private String OtherManufacturerDetails;
        private String PostalCode;
        private String StateProvince;
        private List<VehicleType> VehicleTypes;

        public String getMfr_CommonName() {
            return Mfr_CommonName;
        }

        public void setMfr_CommonName(String mfr_CommonName) {
            Mfr_CommonName = mfr_CommonName;
        }

        public int getMfr_ID() {
            return Mfr_ID;
        }

        public void setMfr_ID(int mfr_ID) {
            Mfr_ID = mfr_ID;
        }

        public String getMfr_Name() {
            return Mfr_Name;
        }

        public void setMfr_Name(String mfr_Name) {
            Mfr_Name = mfr_Name;
        }

        public String getOtherManufacturerDetails() {
            return OtherManufacturerDetails;
        }

        public void setOtherManufacturerDetails(String otherManufacturerDetails) {
            OtherManufacturerDetails = otherManufacturerDetails;
        }

        public String getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(String postalCode) {
            PostalCode = postalCode;
        }

        public String getStateProvince() {
            return StateProvince;
        }

        public void setStateProvince(String stateProvince) {
            StateProvince = stateProvince;
        }

        public List<VehicleType> getVehicleTypes() {
            return VehicleTypes;
        }

        public void setVehicleTypes(List<VehicleType> vehicleTypes) {
            VehicleTypes = vehicleTypes;
        }
    }

    public static class VehicleType {
        private String GVWRFrom;
        private String GVWRTo;
        private boolean IsPrimary;
        private String Name;

        public String getGVWRFrom() {
            return GVWRFrom;
        }

        public void setGVWRFrom(String GVWRFrom) {
            this.GVWRFrom = GVWRFrom;
        }

        public String getGVWRTo() {
            return GVWRTo;
        }

        public void setGVWRTo(String GVWRTo) {
            this.GVWRTo = GVWRTo;
        }

        public boolean isPrimary() {
            return IsPrimary;
        }

        public void setPrimary(boolean primary) {
            IsPrimary = primary;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }

    @GetMapping("/search")
    public String carPage(Model model,
                          @RequestParam(value = "vehicleName", required = false) String vehicleName,
                          @RequestParam(value = "yearOfModel", required = false) String yearOfModel,
                          @RequestParam(value = "price", required = false) String price) {

        // Make the API call and get the JSON response
        String jsonData = carApiClient.pingApi("vehicles/getmanufacturerdetails/" + vehicleName + "?format=json");

        // Parse the JSON data and extract the required information
        List<RentedCarDetails> rentedCarDetailsList = parseSearchResultsJsonData(jsonData);

        // Pass the list of rented car details to the Thymeleaf template
        model.addAttribute("rentedCarDetailsList", rentedCarDetailsList);

        if (vehicleName != null) {
            String endpointAndQueryParams = "vehicles/getmanufacturerdetails/" + vehicleName + "?format=json";
            jsonData = carApiClient.pingApi(endpointAndQueryParams);
            model.addAttribute("jsonData", jsonData);
        }

        if (vehicleName == null && yearOfModel == null && price == null) {
            // Return to the search page if all search parameters are empty
            model.addAttribute("message", "Please enter at least one search parameter.");
            return "search";
        }

        // Perform the search using the CarApiClient
        if (Objects.requireNonNull(vehicleName).isBlank() && Objects.requireNonNull(yearOfModel).isBlank() && price.isBlank()) {
            // Return to the search page if all search parameters are empty
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

    private List<RentedCarDetails> parseSearchResultsJsonData(String jsonData) {
        List<RentedCarDetails> rentedCarDetailsList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);

            // Check if the JSON data contains the "Results" array
            if (rootNode.has("Results") && rootNode.get("Results").isArray()) {
                for (JsonNode resultNode : rootNode.get("Results")) {
                    RentedCarDetails rentedCarDetails = new RentedCarDetails();

                    rentedCarDetails.setMfr_CommonName(resultNode.get("Mfr_CommonName").asText());
                    rentedCarDetails.setMfr_ID(resultNode.get("Mfr_ID").asInt());
                    rentedCarDetails.setMfr_Name(resultNode.get("Mfr_Name").asText());
                    rentedCarDetails.setOtherManufacturerDetails(resultNode.get("OtherManufacturerDetails").asText());
                    rentedCarDetails.setPostalCode(resultNode.get("PostalCode").asText());
                    rentedCarDetails.setStateProvince(resultNode.get("StateProvince").asText());

                    List<VehicleType> vehicleTypes = new ArrayList<>();
                    if (resultNode.has("VehicleTypes") && resultNode.get("VehicleTypes").isArray()) {
                        for (JsonNode typeNode : resultNode.get("VehicleTypes")) {
                            VehicleType vehicleType = new VehicleType();
                            vehicleType.setGVWRFrom(typeNode.get("GVWRFrom").asText());
                            vehicleType.setGVWRTo(typeNode.get("GVWRTo").asText());
                            vehicleType.setPrimary(typeNode.get("IsPrimary").asBoolean());
                            vehicleType.setName(typeNode.get("Name").asText());
                            vehicleTypes.add(vehicleType);
                        }
                    }

                    rentedCarDetails.setVehicleTypes(vehicleTypes);
                    rentedCarDetailsList.add(rentedCarDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rentedCarDetailsList;
    }
}