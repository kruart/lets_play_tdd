package ua.kruart.tdd.finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arthur on 12.12.2016.
 */
public class GrowthRateTest {

    @Test
    public void interest() {
        GrowthRate rate = new GrowthRate(10);
        assertEquals(new Dollars(100) , rate.growthFor(new Dollars(1000)));
    }

    @Test
    public void valueObject() {
        GrowthRate rate1a = new GrowthRate(10);
        GrowthRate rate1b = new GrowthRate(10);
        GrowthRate rate2 = new GrowthRate(20);

        assertEquals("10.0%", rate1a.toString());
        assertTrue("same rate is equal", rate1a.equals(rate1b));
        assertFalse("different rates are not equal", rate1a.equals(rate2));
        assertTrue("same rates have same hash code", rate1a.hashCode() == rate1b.hashCode());
    }
}
