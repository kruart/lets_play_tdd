package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 12.12.2016.
 */
public class InterestRate {

    private double rate;

    public InterestRate(double rateAsPercentage) {
        this.rate = rateAsPercentage / 100.0;
    }

    public int interestOn(int amount) {
        return (int)(amount * rate);
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
