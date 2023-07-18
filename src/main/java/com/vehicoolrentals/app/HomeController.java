package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The HomeController class is a Spring MVC controller responsible for handling home-related requests.
 */
@Controller
public class HomeController {
    /**
     * Handles the request to the root URL ("/") and returns the home page.
     *
     * @param model the Model object to populate with data
     * @return the name of the view to render
     */
    @GetMapping("/")
    public String carPage(Model model) {
        model.addAttribute("content", "index");
        model.addAttribute("message", "Your future car awaits you!");
        return "layout";
    }
}