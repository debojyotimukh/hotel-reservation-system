import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {
    private static List<Hotel> hotelList = new ArrayList<>();

    public static boolean addHotel(Hotel hotel) {
        if (hotel == null)
            return false;
        if (hotelList.contains(hotel))
            return false;
        hotelList.add(hotel);
        return true;
    }

    public static String getCheapestHotel(String... dates) {
        Hotel cheapestHotel = hotelList.get(0);
        double cheapestRate = hotelList.get(0).getPrice(dates);
        for (Hotel hotel : hotelList) {
            if (hotel.getPrice(dates) < cheapestRate) {
                cheapestHotel = hotel;
                cheapestRate = hotel.getPrice(dates);
            }
        }
        return cheapestHotel.getName() + ", Total Rates: $" + Math.round(cheapestRate);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to hotel reservation program");
        addHotel(new Hotel("Lakewood", 110, 90));
        addHotel(new Hotel("Bridgewood", 160, 60));
        addHotel(new Hotel("Ridgewood", 220, 150));
        Scanner sc = new Scanner(System.in);
        String[] dates = sc.nextLine().split(",");

        System.out.println(getCheapestHotel(dates));

    }
}
