package ua.kruart.tdd.finances;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRateTest {

    @Test
    public void nothing() {
        TaxRate taxRate = new TaxRate(0);
        assertEquals(0, taxRate.simpleTaxFor(1000));
        assertEquals(0, taxRate.compoundTaxFor(1000));
    }

    @Test
    public void simpleTaxJustAppliesTaxRateToAmount() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(250, taxRate.simpleTaxFor(1000));
    }

    @Test
    public void compoundTaxIsTheAmountOfTaxThatIsIncurredIfYouAlsoPayTaxOnTheTax() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(333, taxRate.compoundTaxFor(1000));
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
