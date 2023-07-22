package com.vehicoolrentals.app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

public class FirebaseUserController {

    public static String getUid() {
        // Get the user ID (UID) from the client-side and pass it to the server-side
        // This value should be obtained through client-side JavaScript using Firebase Auth SDK
        String uidFromClient = "Aq0y7VHcGcV6OezfPceVlqJo0qD3";

        // For this example, we're just returning a hardcoded UID, but in a real scenario,
        // you should securely pass the UID from the client-side to the server-side.
        return uidFromClient;
    }

    public String getEmail() throws FirebaseAuthException {
        // Get the authenticated user from Firebase Authentication
        UserRecord user = FirebaseAuth.getInstance().getUser(getUid());

        if (user != null) {
            // If the user is authenticated, return the user's email
            return user.getEmail();
        } else {
            // If the user is not authenticated, return null or throw an exception
            return null;
        }
    }

    public String getDisplayName() throws FirebaseAuthException {
        // Get the authenticated user from Firebase Authentication
        UserRecord user = FirebaseAuth.getInstance().getUser(getUid());

        if (user != null) {
            // If the user is authenticated, return the user's display name
            return user.getDisplayName();
        } else {
            // If the user is not authenticated, return null or throw an exception
            return null;
        }
    }

    public String getPhotoUrl() throws FirebaseAuthException {
        // Get the authenticated user from Firebase Authentication
        UserRecord user = FirebaseAuth.getInstance().getUser(getUid());

        if (user != null) {
            // If the user is authenticated, return the user's profile picture URL
            return user.getPhotoUrl();
        } else {
            // If the user is not authenticated, return null or throw an exception
            return null;
        }
    }

    public String getPhoneNumber() throws FirebaseAuthException {
        // Get the authenticated user from Firebase Authentication
        UserRecord user = FirebaseAuth.getInstance().getUser(getUid());

        if (user != null) {
            // If the user is authenticated, return the user's phone number
            return user.getPhoneNumber();
        } else {
            // If the user is not authenticated, return null or throw an exception
            return null;
        }
    }
}