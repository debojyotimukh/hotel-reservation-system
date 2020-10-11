import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    public Hotel lakewood, bridgewood, ridgewood;

    @Before
    public void init() {
        lakewood = new Hotel("Lakewood", 110, 90);
        bridgewood = new Hotel("Bridgewood", 160, 60);
        ridgewood = new Hotel("Ridgewood", 220, 150);
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
        Assert.assertFalse(HotelReservation.addHotel(lakewood));
    }
}
