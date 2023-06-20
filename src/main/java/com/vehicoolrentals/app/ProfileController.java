package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String carPage(Model model) {
        model.addAttribute("content", "profile");
        model.addAttribute("message", "Profile Page Placeholder");
        return "layout";
    }
}