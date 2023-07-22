package com.vehicoolrentals.app.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    /**
     * Given a user's name is Bob when they insert their name then it will return valid.
     */
    @Test
    void getName() {
        User user = new User();
        user.setName("Bob");
        assertTrue(user.getName() == "Bob");
    }

    /**
     * Given a user's name is Alex when they insert their name then it will return valid.
     */
    @Test
    void getName2() {
        User user = new User();
        user.setName("Alex");
        assertTrue(user.getName() == "Alex");
    }


    /**
     * Given a user's email is Bob23@gmail.com when they insert their email then it will return valid.
     */
    @Test
    void getEmail(){
        User user = new User();
        user.setEmail("Bob23@gmail.com");
        assertTrue(user.getEmail() == "Bob23@gmail.com");
    }

    /**
     * Given a user's email is Alex220@outlook.com when they insert their email then it will return valid.
     */
    @Test
    void getEmail2(){
        User user = new User();
        user.setEmail("Alex220@outlook.com");
        assertTrue(user.getEmail() == "Alex220@outlook.com");
    }

    /**
     * Given a user's phone number is 5139874321 when they insert their phone number then it will return valid.
     */
    @Test
    void getPhoneNumber(){
        User user = new User();
        user.setPhoneNumber("5139874321");
        assertTrue(user.getPhoneNumber() == "5139874321");

    }

    /**
     * Given a user's phone number is 8129871234 when they insert their phone number then it will return valid.
     */
    @Test
    void getPhoneNumber2(){
        User user = new User();
        user.setPhoneNumber("8129871234");
        assertTrue(user.getPhoneNumber() == "8129871234");

    }

}

