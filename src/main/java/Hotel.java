public class Hotel implements Comparable<Hotel> {
    private final String name;
    private double regularWeekdayRates;
    private double regularWeekendRates;
    private double specialWeekdayRates;
    private double specialWeekendRates;

    public enum CUSTOMER_TYPE {
        REGULAR, REWARDS;
    }

    private final int rating;

    public Hotel(String name, double regularWeekdayRates, double regularWeekendRates, double specialWeekdayRates,
            double specialWeekendRates, int rating) {
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

    public double getPrice(CUSTOMER_TYPE cType, String start, String end) {
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

    public void setSpecialWeekdayRates(double specialWeekdayRates) {
        this.specialWeekdayRates = specialWeekdayRates;
    }

    public double getSpecialWeekendRates() {
        return specialWeekendRates;
    }

    public void setSpecialWeekendRates(double specialWeekendRates) {
        this.specialWeekendRates = specialWeekendRates;
    }

}
