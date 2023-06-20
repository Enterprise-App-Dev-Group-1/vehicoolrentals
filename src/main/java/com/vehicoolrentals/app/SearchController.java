package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String carPage(Model model) {
        model.addAttribute("content", "search");
        model.addAttribute("message", "Search Page Placeholder");
        return "layout";
    }
}