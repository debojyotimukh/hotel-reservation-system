package com.capgemini.training.java.hotelreservation;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateUtilTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void isWeekendTrueTest() {
        Assert.assertTrue(DateUtil.isWeekend("12Sep2020"));
    }

    @Test
    public void isWeekendFalseTest() {
        Assert.assertFalse(DateUtil.isWeekend("11Sep2020"));
    }

    @Test
    public void numberOfSaturdaysAndSundaysCountTest() throws InvalidDateException {
        Assert.assertEquals(1, DateUtil.countSaturdaysAndSundays("11Sep2020", "12Sep2020"));
        Assert.assertEquals(3, DateUtil.numberOfWeekdays("09Oct2020", "13Oct2020"));
    }

    @Test
    public void invalidDateRangeExceptionTest() throws InvalidDateException {
        exception.expect(InvalidDateException.class);
        exception.expectMessage("Check-in date caanot be after checkout");
        DateUtil.countSaturdaysAndSundays("10Oct2020", "08Oct2020");
    }
}
