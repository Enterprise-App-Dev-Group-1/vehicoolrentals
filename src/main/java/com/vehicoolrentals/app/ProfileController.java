package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The ProfileController class is a Spring MVC controller responsible for handling profile-related requests.
 */
@Controller
public class ProfileController {
    /**
     * Handles the request to the "/profile" URL and returns the profile page.
     *
     * @param model the Model object to populate with data
     * @return the name of the view to render
     */

    @GetMapping("/profile")
    public String carPage(Model model) {
        model.addAttribute("content", "profile");
        model.addAttribute("message", "Profile Page Placeholder");
        return "layout";
    }
}