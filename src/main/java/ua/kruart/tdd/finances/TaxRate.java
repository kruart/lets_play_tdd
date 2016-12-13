package ua.kruart.tdd.finances;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRate {

    private double rate;

    public TaxRate(double rateAsPercentage) {
        this.rate = rateAsPercentage / 100.0;
    }

    public Dollars simpleTaxFor(Dollars amount) {
        return new Dollars((int)(rate * amount.toInt()));
    }

    public Dollars compoundTaxFor(Dollars amount) {
        int amountAsInt = amount.toInt();
        return new Dollars((int)((amountAsInt / (1 - rate)) - amountAsInt));
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
