package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    @GetMapping("/car")
    public String carPage(Model model) {
        model.addAttribute("content", "car");
        model.addAttribute("message", "Your future car awaits you!");
        return "layout";
    }
}