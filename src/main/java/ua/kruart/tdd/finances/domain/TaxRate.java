package ua.kruart.tdd.finances.domain;

import ua.kruart.tdd.finances.util.Require;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRate {

    private double rateAsPercentage;

    public TaxRate(double rateAsPercentage) {
        Require.that(rateAsPercentage > 0, "tax rateAsPercentage must be positive(and not zero); was " + rateAsPercentage);
        this.rateAsPercentage = rateAsPercentage;
    }

    public Dollars simpleTaxFor(Dollars amount) {
        return amount.percentage(rateAsPercentage);
    }

    public Dollars compoundTaxFor(Dollars amount) {
        double compoundRate = (100 / (100 - rateAsPercentage)) - 1;
        return amount.percentage(compoundRate * 100);
    }

    @Override
    public String toString() {
        return (rateAsPercentage)+ "%";
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(rateAsPercentage);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxRate taxRate = (TaxRate) o;

        return Double.compare(taxRate.rateAsPercentage, rateAsPercentage) == 0;
    }
}
