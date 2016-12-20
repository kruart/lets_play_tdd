package ua.kruart.tdd.finances.domain;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRateTest {

    @Test
    public void simpleTaxJustAppliesTaxRateToAmount() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(new Dollars(250), taxRate.simpleTaxFor(new Dollars(1000)));
    }

    @Test
    public void compoundTaxIsTheAmountOfTaxThatIsIncurredIfYouAlsoPayTaxOnTheTax() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(new Dollars(333), taxRate.compoundTaxFor(new Dollars(1000)));
    }

    @Test
    public void valueObject() {
        TaxRate rate1a = new TaxRate(33);
        TaxRate rate2b = new TaxRate(33);
        TaxRate rate2 = new TaxRate(40);

        assertEquals("33.0%", rate1a.toString());
        assertTrue("same values should be equal", rate1a.equals(rate2b));
        assertFalse("different values should be false", rate1a.equals(rate2));
        assertTrue("same values have same hash code", rate1a.hashCode() == rate2b.hashCode());
    }

}
