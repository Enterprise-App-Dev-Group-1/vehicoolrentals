package com.vehicoolrentals.app.domain;

import com.vehicoolrentals.app.business.CarService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class CarTest {

    /**
     * Given a car's price is 1000 when listed on website then its price is 1000.
     */
    @Test
    void getCarPrice() {
        Car car = new Car(1,"","",1);
        car.setCarPrice(1000);
        assertTrue(car.getCarPrice() == 1000);
    }

    /**
     * Given a car's price is 2000 when listed on website then its price is 2000.
     */
    @Test
    void getCarPrice2() {
        Car car = new Car(1,"","",1);
        car.setCarPrice(2000);
        assertTrue(car.getCarPrice() == 2000);
    }

    /**
     * Given a car's price is 3000 when listed on website then 4000 is the wrong price.
     */
    @Test
    void getCarPrice3() {
        Car car = new Car(1,"","",1);
        car.setCarPrice(3000);
        assertFalse(car.getCarPrice() == 4000);
    }

    /**
     * Given a car's location is Cincinnati when listed on website then its location is Cincinnati.
     */
    @Test
    void getCarLocation() {
        Car car = new Car(1,"","",1);
        car.setCarLocation("Cincinnati");
        assertTrue(car.getCarLocation() == "Cincinnati");
    }

    /**
     * Given a car's location is Dayton when listed on website then its location is Dayton.
     */
    @Test
    void getCarLocation2() {
        Car car = new Car(1,"","",1);
        car.setCarLocation("Dayton");
        assertTrue(car.getCarLocation() == "Dayton");
    }

    /**
     * Given a car's location is Chicago when listed on website then Texas is the wrong location.
     */
    @Test
    void getCarLocation3() {
        Car car = new Car(1,"","",1);
        car.setCarLocation("Chicago");
        assertFalse(car.getCarLocation() == "Texas");
    }

    /**
     * Given a car's year is 2020 when listed on website then its year is 2020.
     */
    @Test
    void getYear() {
        Car car = new Car(1,"","",1);
        car.setYear(2020);
        assertTrue(car.getYear() == 2020);
    }

    /**
     * Given a car's year is 2000 when listed on website then its year is 2000.
     */
    @Test
    void getYear2() {
        Car car = new Car(1,"","",1);
        car.setYear(2000);
        assertTrue(car.getYear() == 2000);
    }

    /**
     * Given a car's year is 2010 when listed on website then 2020 is the wrong year.
     */
    @Test
    void getYear3() {
        Car car = new Car(1,"","",1);
        car.setYear(2010);
        assertFalse(car.getYear() == 2020);
    }

}