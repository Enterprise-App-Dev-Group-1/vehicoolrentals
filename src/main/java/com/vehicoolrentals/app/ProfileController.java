package com.vehicoolrentals.app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.vehicoolrentals.app.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profilePage(Model model, @SessionAttribute(name = "uid", required = false) String uid) {
        if (uid == null) {
            // Redirect to the login page if the UID is not found in the session
            return "redirect:/login";
        }

        try {
            User userData;
            if ("1234567890".equals(uid)) {
                // If UID is the specific value, show default data
                userData = getDefaultProfileData();
            } else {
                // Otherwise, fetch data from Firebase
                userData = fetchUserDataFromFirebase(uid);
            }

            // Add the user data to the model to be used in the Thymeleaf template
            model.addAttribute("userData", userData);

            // Return the name of the Thymeleaf template (profile.html)
            return "profile";
        } catch (FirebaseAuthException e) {
            // Handle FirebaseAuthException if necessary
            model.addAttribute("errorMessage", "Error fetching user data from Firebase");
            return "error";
        }
    }

    private User fetchUserDataFromFirebase(String uid) throws FirebaseAuthException {
        UserRecord user = FirebaseAuth.getInstance().getUser(uid);

        User userData = new User();
        userData.setId(Integer.parseInt(user.getUid()));
        userData.setName(user.getDisplayName());
        userData.setEmail(user.getEmail());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setProfilePicture(user.getPhotoUrl());
        // Add other values as needed
        return userData;
    }

    // Method to return default profile data when the UID is a specific value
    private User getDefaultProfileData() {
        User defaultData = new User();
        defaultData.setId(1);
        defaultData.setName("John Doe");
        defaultData.setEmail("john.doe@example.com");
        defaultData.setPhoneNumber("+1234567890");
        defaultData.setProfilePicture("https://secure.gravatar.com/avatar/c89b2bb92df91508e14172097a5e17da?s=480&r=pg&d=https%3A%2F%2Fssl.gstatic.com%2Fs2%2Fprofiles%2Fimages%2Fsilhouette80.png");
        // Add other default values as needed
        return defaultData;
    }
}