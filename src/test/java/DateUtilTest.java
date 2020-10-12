import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class DateUtilTest {
    @Test
    public void isWeekendTrueTest() {
        Assert.assertTrue(DateUtil.isWeekend("12Sep2020"));
    }

    @Test
    public void isWeekendFalseTest() {
        Assert.assertFalse(DateUtil.isWeekend("11Sep2020"));
    }

    @Test
    public void numberOfSaturdaysAndSundaysCountTest() {
        Assert.assertEquals(2, DateUtil.countSaturdaysAndSundays("09Oct2020", "13Oct2020"));
    }
}
