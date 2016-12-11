package ua.kruart.tdd.finances;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRateTest {

    @Test
    public void nothing() {
        TaxRate taxRate = new TaxRate(0);
        assertEquals(0, taxRate.taxFor(1000));
    }

    @Test
    public void simpleTax() {
        TaxRate taxRate = new TaxRate(0);
        assertEquals(250, taxRate.taxFor(1000));
    }
}
