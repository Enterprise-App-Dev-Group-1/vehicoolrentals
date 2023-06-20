package com.vehicoolrentals.app.domain;

public class User implements IUser {
    public int Id;
    public String Name;
    public String Email;
    public String PhoneNumber;
    public String ProfilePicture;

    @Override
    public String getProfilePicture() {
        return ProfilePicture;
    }

    @Override
    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        Id = id;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
