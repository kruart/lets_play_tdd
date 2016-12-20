package ua.kruart.tdd.finances.domain;

import ua.kruart.tdd.finances.util.Require;

/**
 * Created by Arthur on 12.12.2016.
 */
public class InterestRate {

    private double rate;

    public InterestRate(double rateAsPercentage) {
        Require.that(rateAsPercentage > 0, "tax rate must be positive(and not zero); was " + rateAsPercentage);
        this.rate = rateAsPercentage / 100.0;
    }

    public Dollars interestOn(Dollars amount) {
        return new Dollars((int)(amount.toInt() * rate));
    }

    @Override
    public String toString() {
        return (rate * 100) + "%";
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(rate);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterestRate that = (InterestRate) o;

        return Double.compare(that.rate, rate) == 0;

    }
}
