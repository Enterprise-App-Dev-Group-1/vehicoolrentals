package com.vehicoolrentals.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        // Implement your authentication logic here
        // For simplicity, we'll just check if the username and password are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            return "index"; // Replace "success" with the name of the success page
        } else {
            return "login"; // Return to the login page with an error message
        }
    }

    @GetMapping("/logout")
    public String logout() {
        // Implement your logout logic here, such as clearing the session or Firebase authentication state.
        // For simplicity, we'll just redirect to the login page.
        return "redirect:/login";
    }
}