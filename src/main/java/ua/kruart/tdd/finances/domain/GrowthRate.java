package ua.kruart.tdd.finances.domain;

import ua.kruart.tdd.finances.util.Require;

/**
 * Created by Arthur on 12.12.2016.
 */
public class GrowthRate {

    private double rateAsPercentage;

    public GrowthRate(double rateAsPercentage) {
        Require.that(rateAsPercentage > 0, "tax rateAsPercentage must be positive(and not zero); was " + rateAsPercentage);
        this.rateAsPercentage = rateAsPercentage;
    }

    public Dollars growthFor(Dollars amount) {
        return amount.percentage(rateAsPercentage);
    }

    @Override
    public String toString() {
        return (rateAsPercentage) + "%";
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

        GrowthRate that = (GrowthRate) o;

        return Double.compare(that.rateAsPercentage, rateAsPercentage) == 0;

    }
}
