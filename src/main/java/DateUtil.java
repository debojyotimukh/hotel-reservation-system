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

    public static int countSaturdaysAndSundays(String start, String end) {
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        int numberOfDays = (int) DAYS.between(startDate, endDate);
        int numberOfWeekendDays = 0;
        for (int i = 0; i < numberOfDays; i++) {
            if (startDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    || startDate.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                numberOfWeekendDays++;
            startDate = startDate.plusDays(1);
        }
        return numberOfWeekendDays;
    }

    public static int numberOfWeekdays(String start, String end) {
        LocalDate startDate = LocalDate.parse(start, formatter);
        LocalDate endDate = LocalDate.parse(end, formatter);
        int numberOfDays = (int) DAYS.between(startDate, endDate);
        return numberOfDays - countSaturdaysAndSundays(start, end);
    }
}
