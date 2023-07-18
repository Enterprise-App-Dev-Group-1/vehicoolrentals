package com.vehicoolrentals.app.domain;

/**
 * The User class represents a user entity that implements the IUser interface.
 */
public class User implements IUser {
    public int Id;
    public String Name;
    public String Email;
    public String PhoneNumber;
    public String ProfilePicture;

    /**
     * Retrieves the profile picture of the user.
     *
     * @return the profile picture of the user
     */
    @Override
    public String getProfilePicture() {
        return ProfilePicture;
    }

    /**
     * Sets the profile picture of the user.
     *
     * @param profilePicture the profile picture of the user to set
     */
    @Override
    public void setProfilePicture(String profilePicture) {
        ProfilePicture = profilePicture;
    }

    /**
     * Retrieves the ID of the user.
     *
     * @return the ID of the user
     */
    @Override
    public int getId() {
        return Id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the ID of the user to set
     */
    @Override
    public void setId(int id) {
        Id = id;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    @Override
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the name of the user to set
     */
    @Override
    public void setName(String name) {
        Name = name;
    }

    /**
     * Retrieves the email of the user.
     *
     * @return the email of the user
     */
    @Override
    public String getEmail() {
        return Email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email of the user to set
     */
    @Override
    public void setEmail(String email) {
        Email = email;
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return the phone number of the user
     */
    @Override
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber the phone number of the user to set
     */
    @Override
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
