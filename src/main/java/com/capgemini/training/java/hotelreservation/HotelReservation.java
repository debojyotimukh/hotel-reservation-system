package com.capgemini.training.java.hotelreservation;

import java.util.*;
import java.util.Map.Entry;

public class HotelReservation {
    private List<Hotel> hotelList = new ArrayList<>();

    public boolean addHotel(Hotel hotel) {
        if (hotel == null)
            return false;
        if (hotelList.contains(hotel))
            return false;
        hotelList.add(hotel);
        return true;
    }

    public Entry<Hotel, Double> getCheapestBestRatedHotel(CUSTOMER_TYPE cType, String start, String end)
            throws InvalidDateException {
        Map<Hotel, Double> map = new TreeMap<>();
        for (Hotel hotel : hotelList) {
            map.put(hotel, hotel.getPrice(cType, start, end));
        }

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get();

    }

    public Entry<Hotel, Double> getBestRatedHotel(CUSTOMER_TYPE cType, String start, String end)
            throws InvalidDateException {
        hotelList.sort(Comparator.naturalOrder());
        Hotel bestRatedHotel = hotelList.stream().sorted(Comparator.naturalOrder()).findFirst().get();

        Map<Hotel, Double> map = new HashMap<>();
        map.put(bestRatedHotel, bestRatedHotel.getPrice(cType, start, end));
        return map.entrySet().stream().findFirst().get();
    }

    public static void printToConsole(Entry<Hotel, Double> result) {
        System.out.println(result.getKey().getName() + ", Rating: " + result.getKey().getRating() + ", Rate: "
                + result.getValue());
    }

    public static void main(String[] args) throws InvalidHotelAttributeException, InvalidCustomerTypeException {
        System.out.println("Welcome to hotel reservation program");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        hotelReservation.addHotel(new Hotel("Bridgewood", 150, 50, 110, 50, 4));
        hotelReservation.addHotel(new Hotel("Ridgewood", 220, 150, 100, 40, 5));
        Scanner sc = new Scanner(System.in);
        String[] dates = sc.nextLine().replaceAll(" ", "").split(",");
        sc.close();
        if ((!dates[0].equalsIgnoreCase("Regular")) && (!dates[0].equalsIgnoreCase("Reward")))
            throw new InvalidCustomerTypeException();
        CUSTOMER_TYPE cType = dates[0].equalsIgnoreCase("Regular") ? CUSTOMER_TYPE.REGULAR : CUSTOMER_TYPE.REWARDS;
        try {
            printToConsole(hotelReservation.getCheapestBestRatedHotel(cType, dates[1], dates[2]));
        } catch (InvalidDateException e) {
            e.getMessage();
        }

    }
}
