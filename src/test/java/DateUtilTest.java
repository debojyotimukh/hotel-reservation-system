import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class DateUtilTest {
    @Test
    public void isWeekendTrueTest() throws ParseException {
        Assert.assertTrue(DateUtil.isWeekend("12Sep2020"));
    }

    @Test
    public void isWeekendFalseTest() throws ParseException {
        Assert.assertFalse(DateUtil.isWeekend("11Sep2020"));
    }
}
