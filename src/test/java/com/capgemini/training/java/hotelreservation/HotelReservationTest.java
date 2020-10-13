package com.capgemini.training.java.hotelreservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    public Hotel lakewood, bridgewood, ridgewood;

    @Before
    public void init() {
        lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
        ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);
    }

    @Test
    public void hotelPriceCheck() {
        Assert.assertEquals(110, lakewood.getRegularWeekdayRates(), 0.00001);
        Assert.assertEquals(90, lakewood.getRegularWeekendRates(), 0.00001);

    }

    @Test
    public void hotelAddInReservationSystem() {
        Assert.assertTrue(HotelReservation.addHotel(lakewood));
        Assert.assertTrue(HotelReservation.addHotel(bridgewood));
        Assert.assertTrue(HotelReservation.addHotel(ridgewood));
        Assert.assertFalse(HotelReservation.addHotel(lakewood)); // check duplicate
    }
}
