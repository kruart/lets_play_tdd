package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRate {

    private double rate;

    public TaxRate(double rateAsPercentage) {
        this.rate = rateAsPercentage / 100.0;
    }

    public int rate() {
        return (int)(rate * 100);   // TODO: DELETE ME
    }

    public int simpleTaxFor(int amount) {
        return (int)(rate * amount);
    }

    public int compoundTaxFor(int amount) {
        return (int)((amount / (1 - rate)) - amount);
    }

    @Override
    public String toString() {
        return (rate * 100)+ "%";
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

        TaxRate taxRate = (TaxRate) o;

        return Double.compare(taxRate.rate, rate) == 0;
    }
}
