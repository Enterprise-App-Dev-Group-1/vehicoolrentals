package com.vehicoolrentals.app.domain;

/**
 * The IUser interface defines the properties and methods for a user entity.
 */
public interface IUser {
    /**
     * Retrieves the profile picture of the user.
     *
     * @return the profile picture of the user
     */
    String getProfilePicture();

    /**
     * Sets the profile picture of the user.
     *
     * @param profilePicture the profile picture of the user to set
     */
    void setProfilePicture(String profilePicture);

    /**
     * Retrieves the ID of the user.
     *
     * @return the ID of the user
     */
    int getId();

    /**
     * Sets the ID of the user.
     *
     * @param id the ID of the user to set
     */
    void setId(int id);

    /**
     * Retrieves the name of the user.
     *
     * @return the name of the user
     */
    String getName();

    /**
     * Sets the name of the user.
     *
     * @param name the name of the user to set
     */
    void setName(String name);

    /**
     * Retrieves the email of the user.
     *
     * @return the email of the user
     */
    String getEmail();

    /**
     * Sets the email of the user.
     *
     * @param email the email of the user to set
     */
    void setEmail(String email);

    /**
     * Retrieves the phone number of the user.
     *
     * @return the phone number of the user
     */
    String getPhoneNumber();

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber the phone number of the user to set
     */
    void setPhoneNumber(String phoneNumber);
}
