package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentalsController {
    @GetMapping("/rentals")
    public String carPage(Model model) {
        model.addAttribute("content", "rentals");
        model.addAttribute("message", "Rentals Page Placeholder");
        return "layout";
    }
}