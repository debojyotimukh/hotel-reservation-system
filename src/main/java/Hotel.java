import java.text.ParseException;

public class Hotel {
    private final String name;
    private double regularWeekdayRates;
    private double regularWeekendRates;

    public Hotel(String name, double regularWeekdayRates, double regularWeekendRates) {
        this.name = name;
        this.regularWeekdayRates = regularWeekdayRates;
        this.regularWeekendRates = regularWeekendRates;
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

    public double getPrice(String... dates) throws ParseException {
        double rate = 0.0;
        for (String date : dates) {
            if (DateUtil.isWeekend(date))
                rate += regularWeekendRates;
            else rate += regularWeekdayRates;
        }
        return rate;
    }
}
