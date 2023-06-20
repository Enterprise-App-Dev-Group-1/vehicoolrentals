package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String carPage(Model model) {
        model.addAttribute("content", "index");
        model.addAttribute("message", "Your future car awaits you!");
        return "layout";
    }
}