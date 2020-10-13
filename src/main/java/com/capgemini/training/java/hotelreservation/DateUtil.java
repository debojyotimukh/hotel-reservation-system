package com.capgemini.training.java.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateUtil {
    private static final String DATE_PATTERN = "ddMMMyyyy";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static boolean isWeekend(String dateString) {
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public static int countSaturdaysAndSundays(String start, String end) throws InvalidDateException {
        if (start == null || end == null)
            throw new InvalidDateException("Dates cnnot be null");

        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        
        if (startDate.isAfter(endDate))
            throw new InvalidDateException("Check-in date caanot be after checkout");
            
        int numberOfDays = (int) DAYS.between(startDate, endDate);
        int numberOfWeekendDays = 0;
        for (int i = 0; i <= numberOfDays; i++) {
            if (startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    || startDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                numberOfWeekendDays++;
            startDate = startDate.plusDays(1);
        }
        return numberOfWeekendDays;
    }

    public static int numberOfWeekdays(String start, String end) throws InvalidDateException {
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        int numberOfDays = (int) DAYS.between(startDate, endDate) + 1;
        return numberOfDays - countSaturdaysAndSundays(start, end);
    }
}
