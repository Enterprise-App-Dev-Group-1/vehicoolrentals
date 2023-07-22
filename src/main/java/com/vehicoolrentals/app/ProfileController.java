package com.vehicoolrentals.app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.vehicoolrentals.app.FirebaseUserController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage(Model model) throws FirebaseAuthException {
        // Get the authenticated user from Firebase Authentication
        UserRecord user = FirebaseAuth.getInstance().getUser(FirebaseUserController.getUid());

        if (user != null) {
            // If the user is authenticated, retrieve user information
            String uid = user.getUid();
            String email = user.getEmail();
            String name = user.getDisplayName();
            String profilePicUrl = user.getPhotoUrl();
            String phoneNumber = user.getPhoneNumber();
            // Add any other user information you want to display

            // Pass the user information to the view
            model.addAttribute("uid", uid);
            model.addAttribute("email", email);
            model.addAttribute("name", name);
            model.addAttribute("profilePicUrl", profilePicUrl);
            model.addAttribute("phoneNumber", phoneNumber);
        } else {
            // If the user is not authenticated, handle the case accordingly
            model.addAttribute("errorMessage", "You must be logged in to view this page.");
        }

        model.addAttribute("content", "profile");
        // You can add any other attributes you need for the profile page

        return "layout";
    }
}
