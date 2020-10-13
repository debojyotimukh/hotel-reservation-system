package com.capgemini.training.java.hotelreservation;

import java.util.regex.Pattern;

enum CUSTOMER_TYPE {
    REGULAR, REWARDS;
}

public class Hotel implements Comparable<Hotel> {
    private final String name;
    private double regularWeekdayRates;
    private double regularWeekendRates;
    private double specialWeekdayRates;
    private double specialWeekendRates;
    private final int rating;

    public Hotel(String name, double regularWeekdayRates, double regularWeekendRates, double specialWeekdayRates,
            double specialWeekendRates, int rating) throws InvalidHotelAttributeException {
        // validation
        if (regularWeekdayRates < 1 || regularWeekendRates < 1 || specialWeekdayRates < 1 || specialWeekendRates < 1)
            throw new InvalidHotelAttributeException("Rates cannot be less than 1");

        if (!Pattern.matches("[A-Z][a-z]{2,}", name))
            throw new InvalidHotelAttributeException("Illegal hotel name");

        if (rating < 1 || rating > 5)
            throw new InvalidHotelAttributeException("Rating must be between 1-5");

        // assignment
        this.name = name;
        this.regularWeekdayRates = regularWeekdayRates;
        this.regularWeekendRates = regularWeekendRates;
        this.specialWeekdayRates = specialWeekdayRates;
        this.specialWeekendRates = specialWeekendRates;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public double getRegularWeekendRates() {
        return regularWeekendRates;
    }

    public void setRegularWeekendRates(double regularWeekendRates) throws InvalidHotelAttributeException {
        if (regularWeekendRates < 1)
            throw new InvalidHotelAttributeException("Rates cannot be less than 1");

        this.regularWeekendRates = regularWeekendRates;
    }

    public String getName() {
        return name;
    }

    public double getRegularWeekdayRates() {
        return regularWeekdayRates;
    }

    public void setRegularWeekdayRates(double regularWeekdayRates) throws InvalidHotelAttributeException {
        if (regularWeekdayRates < 1)
            throw new InvalidHotelAttributeException("Rates cannot be less than 1");

        this.regularWeekdayRates = regularWeekdayRates;
    }

    public double getPrice(CUSTOMER_TYPE cType, String start, String end) throws InvalidDateException {
        double rate;
        double weekendRates = cType.equals(CUSTOMER_TYPE.REGULAR) ? regularWeekendRates : specialWeekendRates;
        double weekdayRates = cType.equals(CUSTOMER_TYPE.REGULAR) ? regularWeekdayRates : specialWeekdayRates;

        rate = DateUtil.countSaturdaysAndSundays(start, end) * weekendRates
                + DateUtil.numberOfWeekdays(start, end) * weekdayRates;
        return rate;
    }

    @Override
    public int compareTo(Hotel other) {
        return other.rating - this.rating;
    }

    public double getSpecialWeekdayRates() {
        return specialWeekdayRates;
    }

    public void setSpecialWeekdayRates(double specialWeekdayRates) throws InvalidHotelAttributeException {
        if (specialWeekdayRates < 1)
            throw new InvalidHotelAttributeException("Rates cannot be less than 1");

        this.specialWeekdayRates = specialWeekdayRates;
    }

    public double getSpecialWeekendRates() {
        return specialWeekendRates;
    }

    public void setSpecialWeekendRates(double specialWeekendRates) throws InvalidHotelAttributeException {
        if (specialWeekendRates < 1)
            throw new InvalidHotelAttributeException("Rates cannot be less than 1");

        this.specialWeekendRates = specialWeekendRates;
    }

}
