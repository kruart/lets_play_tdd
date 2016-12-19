package ua.kruart.tdd.finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arthur on 19.12.2016.
 */
public class YearTest {

    @Test
    public void nextYear() {
        Year thisYear = new Year(2010);
        assertEquals(new Year(2011), thisYear.nextYear());
    }
    
    @Test
    public void valueObject() {
        Year year1a = new Year(2010);
        Year year1b = new Year(2010);
        Year year2 = new Year(2012);

        assertEquals("2010", year1a.toString());
        assertTrue("years with same value should be equal", year1a.equals(year1b));
        assertFalse("years with different values should not be equal", year1a.equals(year2));
        assertTrue("years with same values should have same hashcode", year1a.hashCode() == year1b.hashCode());
    }
}
