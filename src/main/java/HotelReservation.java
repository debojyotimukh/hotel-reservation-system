import java.util.*;
import java.util.Map.Entry;

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
        Map<Hotel, Double> map = new TreeMap<>();
        for (Hotel hotel : hotelList) {
            map.put(hotel, hotel.getPrice(start, end));
        }

        Entry<Hotel, Double> result = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get();
        return result.getKey().getName() + ", Rating: " + result.getKey().getRating() + ", Rate: " + result.getValue();
    }

    public static String getBestRatedHotel(String start, String end) {
        hotelList.sort(Comparator.naturalOrder());
        return hotelList.get(0).getName() + ", Rate: " + hotelList.get(0).getPrice(start, end);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to hotel reservation program");
        addHotel(new Hotel("Lakewood", 110, 90, 3));
        addHotel(new Hotel("Bridgewood", 150, 50, 4));
        addHotel(new Hotel("Ridgewood", 220, 150, 5));
        Scanner sc = new Scanner(System.in);
        String[] dates = sc.nextLine().replaceAll(" ", "").split(",");
        sc.close();
        System.out.println(getBestRatedHotel(dates[0], dates[1]));

    }
}
