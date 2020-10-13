import java.util.*;

public class HotelReservation {
    private static final List<Hotel> hotelList = new ArrayList<>();

    public static boolean addHotel(Hotel hotel) {
        if (hotel == null)
            return false;
        if (hotelList.contains(hotel))
            return false;
        hotelList.add(hotel);
        return true;
    }

    public static String getCheapestBestRatedHotel(String start, String end) {
        Map<Hotel, Double> rateMap = new HashMap<>();
        for (Hotel hotel : hotelList) {
            if (rateMap.values().stream().min(Double::compareTo).get() >= hotel.getPrice(start, end))
                rateMap.put(hotel, hotel.getPrice(start, end));
        }
        Hotel hotel=rateMap.entrySet().stream().sorted(Comparator.comparing(Hotel::getRating))
    }

    public static void main(String[] args) {
        System.out.println("Welcome to hotel reservation program");
        addHotel(new Hotel("Lakewood", 110, 90, 3));
        addHotel(new Hotel("Bridgewood", 150, 50, 4));
        addHotel(new Hotel("Ridgewood", 220, 150, 5));
        Scanner sc = new Scanner(System.in);
        String[] dates = sc.nextLine().replaceAll(" ", "").split(",");
        sc.close();
        System.out.println(getCheapestBestRatedHotel(dates[0], dates[1]));

    }
}
