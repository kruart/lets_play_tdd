package ua.kruart.tdd.finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arthur on 12.12.2016.
 */
public class InterestRateTest {

    @Test
    public void interest() {
        InterestRate rate = new InterestRate(10);
        assertEquals(new Dollars(100) , rate.interestOn(new Dollars(1000)));
    }

    @Test
    public void valueObject() {
        InterestRate rate1a = new InterestRate(10);
        InterestRate rate1b = new InterestRate(10);
        InterestRate rate2 = new InterestRate(20);

        assertEquals("10.0%", rate1a.toString());
        assertTrue("same rate is equal", rate1a.equals(rate1b));
        assertFalse("different rates are not equal", rate1a.equals(rate2));
        assertTrue("same rates have same hash code", rate1a.hashCode() == rate1b.hashCode());
    }
}
