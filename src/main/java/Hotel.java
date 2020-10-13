
public class Hotel {
    private final String name;
    private double regularWeekdayRates;
    private double regularWeekendRates;
    private static int rating;

    public Hotel(String name, double regularWeekdayRates, double regularWeekendRates, int rating) {
        this.name = name;
        this.regularWeekdayRates = regularWeekdayRates;
        this.regularWeekendRates = regularWeekendRates;
        rating = rating;
    }

    public static int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getRegularWeekendRates() {
        return regularWeekendRates;
    }

    public void setRegularWeekendRates(double regularWeekendRates) {
        this.regularWeekendRates = regularWeekendRates;
    }

    public String getName() {
        return name;
    }

    public double getRegularWeekdayRates() {
        return regularWeekdayRates;
    }

    public void setRegularWeekdayRates(double regularWeekdayRates) {
        this.regularWeekdayRates = regularWeekdayRates;
    }

    public double getPrice(String start, String end) {
        double rate;
        rate = DateUtil.countSaturdaysAndSundays(start, end) * regularWeekendRates +
                DateUtil.numberOfWeekdays(start, end) * regularWeekdayRates;
        return rate;
    }


}
