import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println("Welcome to hotel reservation program");
    }
}
