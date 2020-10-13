import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(1, DateUtil.countSaturdaysAndSundays("11Sep2020", "12Sep2020"));
        Assert.assertEquals(3, DateUtil.numberOfWeekdays("09Oct2020", "13Oct2020"));
    }
}
