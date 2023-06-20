package com.vehicoolrentals.app.domain;

public interface IUser {
    String getProfilePicture();

    void setProfilePicture(String profilePicture);

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);
}
