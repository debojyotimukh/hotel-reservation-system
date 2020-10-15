package com.capgemini.training.java.hotelreservation;

import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    public Hotel lakewood, bridgewood, ridgewood;
    HotelReservation hotelReservation;

    @Before
    public void init() throws InvalidHotelAttributeException {
        lakewood = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        bridgewood = new Hotel("Bridgewood", 150, 50, 110, 50, 4);
        ridgewood = new Hotel("Ridgewood", 220, 150, 100, 40, 5);

        hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
    }

    @Test
    public void hotelPriceCheck() {
        Assert.assertEquals(110, lakewood.getRegularWeekdayRates(), 0.00001);
        Assert.assertEquals(90, lakewood.getRegularWeekendRates(), 0.00001);
    }

    @Test
    public void cheapestBestRatedForRewardCustomer() throws InvalidDateException {

        Entry<Hotel, Double> result = hotelReservation.getCheapestBestRatedHotel(CUSTOMER_TYPE.REWARDS, "11Sep2020",
                "12Sep2020");
        Assert.assertEquals(ridgewood, result.getKey());
        Assert.assertEquals(Double.valueOf(140), result.getValue());
    }

    @Test
    public void cheapestBestRatedForRegularCustomer() throws InvalidDateException {

        Entry<Hotel, Double> result = hotelReservation.getCheapestBestRatedHotel(CUSTOMER_TYPE.REGULAR, "11Sep2020",
                "12Sep2020");
        Assert.assertEquals(bridgewood, result.getKey());
        Assert.assertEquals(Double.valueOf(200), result.getValue());
    }

    @Test
    public void bestRatedForRegularCustomer() throws InvalidDateException {

        Entry<Hotel, Double> result = hotelReservation.getBestRatedHotel(CUSTOMER_TYPE.REGULAR, "11Sep2020",
                "12Sep2020");
        Assert.assertEquals(ridgewood, result.getKey());
        Assert.assertEquals(Double.valueOf(370), result.getValue());
    }

    @Test
    public void hotelAddInReservationSystem() {

        Assert.assertFalse(hotelReservation.addHotel(lakewood)); // check duplicate
    }
}
