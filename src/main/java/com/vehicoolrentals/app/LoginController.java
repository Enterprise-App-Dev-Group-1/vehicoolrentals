package com.vehicoolrentals.app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String idToken = request.getParameter("idToken");

        if (idToken != null) {
            try {
                // Verify the Firebase ID token
                FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
                String uid = decodedToken.getUid();

                // Store the UID in the session
                request.getSession().setAttribute("uid", uid);

                return "index"; // Replace "index" with the name of the success page
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
                model.addAttribute("errorMessage", "Error authenticating the user");
                return "login"; // Return to the login page with an error message
            }
        } else {
            model.addAttribute("errorMessage", "Invalid credentials");
            return "login"; // Return to the login page with an error message
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Clear the UID from the session
        request.getSession().removeAttribute("uid");
        return "redirect:/login";
    }
}