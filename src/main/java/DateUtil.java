import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final String DATE_PATTERN="ddMMMyyyy";
    private static final SimpleDateFormat sdf=new SimpleDateFormat(DATE_PATTERN);
    private static final Calendar calendar=Calendar.getInstance();

    public static boolean isWeekend(String dateString) throws ParseException {
        Date date = sdf.parse(dateString);
        calendar.setTimeInMillis(date.getTime());
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        return (day==Calendar.SATURDAY)||(day==Calendar.SUNDAY);
    }
}
